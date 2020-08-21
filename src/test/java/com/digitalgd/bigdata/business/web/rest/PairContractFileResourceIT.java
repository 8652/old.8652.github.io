package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.BigdataBusinessApp;
import com.digitalgd.bigdata.business.domain.PairContractFile;
import com.digitalgd.bigdata.business.repository.PairContractFileRepository;
import com.digitalgd.bigdata.business.service.PairContractFileService;
import com.digitalgd.bigdata.business.service.dto.PairContractFileDTO;
import com.digitalgd.bigdata.business.service.mapper.PairContractFileMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;

import static com.digitalgd.bigdata.business.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link PairContractFileResource} REST controller.
 */
@SpringBootTest(classes = BigdataBusinessApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class PairContractFileResourceIT {

    private static final String DEFAULT_PAIR_CONTRACT_ID = "AAAAAAAAAA";
    private static final String UPDATED_PAIR_CONTRACT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_FILE_PATH = "AAAAAAAAAA";
    private static final String UPDATED_FILE_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_FILE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FILE_NAME = "BBBBBBBBBB";

    private static final Boolean DEFAULT_DEL_FLAG = false;
    private static final Boolean UPDATED_DEL_FLAG = true;

    private static final ZonedDateTime DEFAULT_CREATE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Autowired
    private PairContractFileRepository pairContractFileRepository;

    @Autowired
    private PairContractFileMapper pairContractFileMapper;

    @Autowired
    private PairContractFileService pairContractFileService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPairContractFileMockMvc;

    private PairContractFile pairContractFile;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PairContractFile createEntity(EntityManager em) {
        PairContractFile pairContractFile = new PairContractFile()
            .pairContractId(DEFAULT_PAIR_CONTRACT_ID)
            .filePath(DEFAULT_FILE_PATH)
            .fileName(DEFAULT_FILE_NAME)
            .delFlag(DEFAULT_DEL_FLAG)
            .createTime(DEFAULT_CREATE_TIME);
        return pairContractFile;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PairContractFile createUpdatedEntity(EntityManager em) {
        PairContractFile pairContractFile = new PairContractFile()
            .pairContractId(UPDATED_PAIR_CONTRACT_ID)
            .filePath(UPDATED_FILE_PATH)
            .fileName(UPDATED_FILE_NAME)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME);
        return pairContractFile;
    }

    @BeforeEach
    public void initTest() {
        pairContractFile = createEntity(em);
    }

    @Test
    @Transactional
    public void createPairContractFile() throws Exception {
        int databaseSizeBeforeCreate = pairContractFileRepository.findAll().size();
        // Create the PairContractFile
        PairContractFileDTO pairContractFileDTO = pairContractFileMapper.toDto(pairContractFile);
        restPairContractFileMockMvc.perform(post("/api/pair-contract-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractFileDTO)))
            .andExpect(status().isCreated());

        // Validate the PairContractFile in the database
        List<PairContractFile> pairContractFileList = pairContractFileRepository.findAll();
        assertThat(pairContractFileList).hasSize(databaseSizeBeforeCreate + 1);
        PairContractFile testPairContractFile = pairContractFileList.get(pairContractFileList.size() - 1);
        assertThat(testPairContractFile.getPairContractId()).isEqualTo(DEFAULT_PAIR_CONTRACT_ID);
        assertThat(testPairContractFile.getFilePath()).isEqualTo(DEFAULT_FILE_PATH);
        assertThat(testPairContractFile.getFileName()).isEqualTo(DEFAULT_FILE_NAME);
        assertThat(testPairContractFile.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testPairContractFile.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
    }

    @Test
    @Transactional
    public void createPairContractFileWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = pairContractFileRepository.findAll().size();

        // Create the PairContractFile with an existing ID
        pairContractFile.setId(1L);
        PairContractFileDTO pairContractFileDTO = pairContractFileMapper.toDto(pairContractFile);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPairContractFileMockMvc.perform(post("/api/pair-contract-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractFileDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PairContractFile in the database
        List<PairContractFile> pairContractFileList = pairContractFileRepository.findAll();
        assertThat(pairContractFileList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkPairContractIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractFileRepository.findAll().size();
        // set the field null
        pairContractFile.setPairContractId(null);

        // Create the PairContractFile, which fails.
        PairContractFileDTO pairContractFileDTO = pairContractFileMapper.toDto(pairContractFile);


        restPairContractFileMockMvc.perform(post("/api/pair-contract-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractFileDTO)))
            .andExpect(status().isBadRequest());

        List<PairContractFile> pairContractFileList = pairContractFileRepository.findAll();
        assertThat(pairContractFileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractFileRepository.findAll().size();
        // set the field null
        pairContractFile.setDelFlag(null);

        // Create the PairContractFile, which fails.
        PairContractFileDTO pairContractFileDTO = pairContractFileMapper.toDto(pairContractFile);


        restPairContractFileMockMvc.perform(post("/api/pair-contract-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractFileDTO)))
            .andExpect(status().isBadRequest());

        List<PairContractFile> pairContractFileList = pairContractFileRepository.findAll();
        assertThat(pairContractFileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllPairContractFiles() throws Exception {
        // Initialize the database
        pairContractFileRepository.saveAndFlush(pairContractFile);

        // Get all the pairContractFileList
        restPairContractFileMockMvc.perform(get("/api/pair-contract-files?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(pairContractFile.getId().intValue())))
            .andExpect(jsonPath("$.[*].pairContractId").value(hasItem(DEFAULT_PAIR_CONTRACT_ID)))
            .andExpect(jsonPath("$.[*].filePath").value(hasItem(DEFAULT_FILE_PATH)))
            .andExpect(jsonPath("$.[*].fileName").value(hasItem(DEFAULT_FILE_NAME)))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG.booleanValue())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(sameInstant(DEFAULT_CREATE_TIME))));
    }
    
    @Test
    @Transactional
    public void getPairContractFile() throws Exception {
        // Initialize the database
        pairContractFileRepository.saveAndFlush(pairContractFile);

        // Get the pairContractFile
        restPairContractFileMockMvc.perform(get("/api/pair-contract-files/{id}", pairContractFile.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(pairContractFile.getId().intValue()))
            .andExpect(jsonPath("$.pairContractId").value(DEFAULT_PAIR_CONTRACT_ID))
            .andExpect(jsonPath("$.filePath").value(DEFAULT_FILE_PATH))
            .andExpect(jsonPath("$.fileName").value(DEFAULT_FILE_NAME))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG.booleanValue()))
            .andExpect(jsonPath("$.createTime").value(sameInstant(DEFAULT_CREATE_TIME)));
    }
    @Test
    @Transactional
    public void getNonExistingPairContractFile() throws Exception {
        // Get the pairContractFile
        restPairContractFileMockMvc.perform(get("/api/pair-contract-files/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePairContractFile() throws Exception {
        // Initialize the database
        pairContractFileRepository.saveAndFlush(pairContractFile);

        int databaseSizeBeforeUpdate = pairContractFileRepository.findAll().size();

        // Update the pairContractFile
        PairContractFile updatedPairContractFile = pairContractFileRepository.findById(pairContractFile.getId()).get();
        // Disconnect from session so that the updates on updatedPairContractFile are not directly saved in db
        em.detach(updatedPairContractFile);
        updatedPairContractFile
            .pairContractId(UPDATED_PAIR_CONTRACT_ID)
            .filePath(UPDATED_FILE_PATH)
            .fileName(UPDATED_FILE_NAME)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME);
        PairContractFileDTO pairContractFileDTO = pairContractFileMapper.toDto(updatedPairContractFile);

        restPairContractFileMockMvc.perform(put("/api/pair-contract-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractFileDTO)))
            .andExpect(status().isOk());

        // Validate the PairContractFile in the database
        List<PairContractFile> pairContractFileList = pairContractFileRepository.findAll();
        assertThat(pairContractFileList).hasSize(databaseSizeBeforeUpdate);
        PairContractFile testPairContractFile = pairContractFileList.get(pairContractFileList.size() - 1);
        assertThat(testPairContractFile.getPairContractId()).isEqualTo(UPDATED_PAIR_CONTRACT_ID);
        assertThat(testPairContractFile.getFilePath()).isEqualTo(UPDATED_FILE_PATH);
        assertThat(testPairContractFile.getFileName()).isEqualTo(UPDATED_FILE_NAME);
        assertThat(testPairContractFile.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testPairContractFile.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingPairContractFile() throws Exception {
        int databaseSizeBeforeUpdate = pairContractFileRepository.findAll().size();

        // Create the PairContractFile
        PairContractFileDTO pairContractFileDTO = pairContractFileMapper.toDto(pairContractFile);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPairContractFileMockMvc.perform(put("/api/pair-contract-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractFileDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PairContractFile in the database
        List<PairContractFile> pairContractFileList = pairContractFileRepository.findAll();
        assertThat(pairContractFileList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePairContractFile() throws Exception {
        // Initialize the database
        pairContractFileRepository.saveAndFlush(pairContractFile);

        int databaseSizeBeforeDelete = pairContractFileRepository.findAll().size();

        // Delete the pairContractFile
        restPairContractFileMockMvc.perform(delete("/api/pair-contract-files/{id}", pairContractFile.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PairContractFile> pairContractFileList = pairContractFileRepository.findAll();
        assertThat(pairContractFileList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
