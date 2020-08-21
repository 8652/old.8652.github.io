package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.BigdataBusinessApp;
import com.digitalgd.bigdata.business.domain.PairContactFile;
import com.digitalgd.bigdata.business.repository.PairContactFileRepository;
import com.digitalgd.bigdata.business.service.PairContactFileService;
import com.digitalgd.bigdata.business.service.dto.PairContactFileDTO;
import com.digitalgd.bigdata.business.service.mapper.PairContactFileMapper;

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
 * Integration tests for the {@link PairContactFileResource} REST controller.
 */
@SpringBootTest(classes = BigdataBusinessApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class PairContactFileResourceIT {

    private static final String DEFAULT_PAIR_CONTACT_ID = "AAAAAAAAAA";
    private static final String UPDATED_PAIR_CONTACT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_FILE_PATH = "AAAAAAAAAA";
    private static final String UPDATED_FILE_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_FILE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FILE_NAME = "BBBBBBBBBB";

    private static final Boolean DEFAULT_DEL_FLAG = false;
    private static final Boolean UPDATED_DEL_FLAG = true;

    private static final ZonedDateTime DEFAULT_CREATE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Autowired
    private PairContactFileRepository pairContactFileRepository;

    @Autowired
    private PairContactFileMapper pairContactFileMapper;

    @Autowired
    private PairContactFileService pairContactFileService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPairContactFileMockMvc;

    private PairContactFile pairContactFile;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PairContactFile createEntity(EntityManager em) {
        PairContactFile pairContactFile = new PairContactFile()
            .pairContactId(DEFAULT_PAIR_CONTACT_ID)
            .filePath(DEFAULT_FILE_PATH)
            .fileName(DEFAULT_FILE_NAME)
            .delFlag(DEFAULT_DEL_FLAG)
            .createTime(DEFAULT_CREATE_TIME);
        return pairContactFile;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PairContactFile createUpdatedEntity(EntityManager em) {
        PairContactFile pairContactFile = new PairContactFile()
            .pairContactId(UPDATED_PAIR_CONTACT_ID)
            .filePath(UPDATED_FILE_PATH)
            .fileName(UPDATED_FILE_NAME)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME);
        return pairContactFile;
    }

    @BeforeEach
    public void initTest() {
        pairContactFile = createEntity(em);
    }

    @Test
    @Transactional
    public void createPairContactFile() throws Exception {
        int databaseSizeBeforeCreate = pairContactFileRepository.findAll().size();
        // Create the PairContactFile
        PairContactFileDTO pairContactFileDTO = pairContactFileMapper.toDto(pairContactFile);
        restPairContactFileMockMvc.perform(post("/api/pair-contact-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContactFileDTO)))
            .andExpect(status().isCreated());

        // Validate the PairContactFile in the database
        List<PairContactFile> pairContactFileList = pairContactFileRepository.findAll();
        assertThat(pairContactFileList).hasSize(databaseSizeBeforeCreate + 1);
        PairContactFile testPairContactFile = pairContactFileList.get(pairContactFileList.size() - 1);
        assertThat(testPairContactFile.getPairContactId()).isEqualTo(DEFAULT_PAIR_CONTACT_ID);
        assertThat(testPairContactFile.getFilePath()).isEqualTo(DEFAULT_FILE_PATH);
        assertThat(testPairContactFile.getFileName()).isEqualTo(DEFAULT_FILE_NAME);
        assertThat(testPairContactFile.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testPairContactFile.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
    }

    @Test
    @Transactional
    public void createPairContactFileWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = pairContactFileRepository.findAll().size();

        // Create the PairContactFile with an existing ID
        pairContactFile.setId(1L);
        PairContactFileDTO pairContactFileDTO = pairContactFileMapper.toDto(pairContactFile);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPairContactFileMockMvc.perform(post("/api/pair-contact-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContactFileDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PairContactFile in the database
        List<PairContactFile> pairContactFileList = pairContactFileRepository.findAll();
        assertThat(pairContactFileList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkPairContactIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContactFileRepository.findAll().size();
        // set the field null
        pairContactFile.setPairContactId(null);

        // Create the PairContactFile, which fails.
        PairContactFileDTO pairContactFileDTO = pairContactFileMapper.toDto(pairContactFile);


        restPairContactFileMockMvc.perform(post("/api/pair-contact-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContactFileDTO)))
            .andExpect(status().isBadRequest());

        List<PairContactFile> pairContactFileList = pairContactFileRepository.findAll();
        assertThat(pairContactFileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContactFileRepository.findAll().size();
        // set the field null
        pairContactFile.setDelFlag(null);

        // Create the PairContactFile, which fails.
        PairContactFileDTO pairContactFileDTO = pairContactFileMapper.toDto(pairContactFile);


        restPairContactFileMockMvc.perform(post("/api/pair-contact-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContactFileDTO)))
            .andExpect(status().isBadRequest());

        List<PairContactFile> pairContactFileList = pairContactFileRepository.findAll();
        assertThat(pairContactFileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllPairContactFiles() throws Exception {
        // Initialize the database
        pairContactFileRepository.saveAndFlush(pairContactFile);

        // Get all the pairContactFileList
        restPairContactFileMockMvc.perform(get("/api/pair-contact-files?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(pairContactFile.getId().intValue())))
            .andExpect(jsonPath("$.[*].pairContactId").value(hasItem(DEFAULT_PAIR_CONTACT_ID)))
            .andExpect(jsonPath("$.[*].filePath").value(hasItem(DEFAULT_FILE_PATH)))
            .andExpect(jsonPath("$.[*].fileName").value(hasItem(DEFAULT_FILE_NAME)))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG.booleanValue())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(sameInstant(DEFAULT_CREATE_TIME))));
    }
    
    @Test
    @Transactional
    public void getPairContactFile() throws Exception {
        // Initialize the database
        pairContactFileRepository.saveAndFlush(pairContactFile);

        // Get the pairContactFile
        restPairContactFileMockMvc.perform(get("/api/pair-contact-files/{id}", pairContactFile.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(pairContactFile.getId().intValue()))
            .andExpect(jsonPath("$.pairContactId").value(DEFAULT_PAIR_CONTACT_ID))
            .andExpect(jsonPath("$.filePath").value(DEFAULT_FILE_PATH))
            .andExpect(jsonPath("$.fileName").value(DEFAULT_FILE_NAME))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG.booleanValue()))
            .andExpect(jsonPath("$.createTime").value(sameInstant(DEFAULT_CREATE_TIME)));
    }
    @Test
    @Transactional
    public void getNonExistingPairContactFile() throws Exception {
        // Get the pairContactFile
        restPairContactFileMockMvc.perform(get("/api/pair-contact-files/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePairContactFile() throws Exception {
        // Initialize the database
        pairContactFileRepository.saveAndFlush(pairContactFile);

        int databaseSizeBeforeUpdate = pairContactFileRepository.findAll().size();

        // Update the pairContactFile
        PairContactFile updatedPairContactFile = pairContactFileRepository.findById(pairContactFile.getId()).get();
        // Disconnect from session so that the updates on updatedPairContactFile are not directly saved in db
        em.detach(updatedPairContactFile);
        updatedPairContactFile
            .pairContactId(UPDATED_PAIR_CONTACT_ID)
            .filePath(UPDATED_FILE_PATH)
            .fileName(UPDATED_FILE_NAME)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME);
        PairContactFileDTO pairContactFileDTO = pairContactFileMapper.toDto(updatedPairContactFile);

        restPairContactFileMockMvc.perform(put("/api/pair-contact-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContactFileDTO)))
            .andExpect(status().isOk());

        // Validate the PairContactFile in the database
        List<PairContactFile> pairContactFileList = pairContactFileRepository.findAll();
        assertThat(pairContactFileList).hasSize(databaseSizeBeforeUpdate);
        PairContactFile testPairContactFile = pairContactFileList.get(pairContactFileList.size() - 1);
        assertThat(testPairContactFile.getPairContactId()).isEqualTo(UPDATED_PAIR_CONTACT_ID);
        assertThat(testPairContactFile.getFilePath()).isEqualTo(UPDATED_FILE_PATH);
        assertThat(testPairContactFile.getFileName()).isEqualTo(UPDATED_FILE_NAME);
        assertThat(testPairContactFile.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testPairContactFile.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingPairContactFile() throws Exception {
        int databaseSizeBeforeUpdate = pairContactFileRepository.findAll().size();

        // Create the PairContactFile
        PairContactFileDTO pairContactFileDTO = pairContactFileMapper.toDto(pairContactFile);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPairContactFileMockMvc.perform(put("/api/pair-contact-files")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContactFileDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PairContactFile in the database
        List<PairContactFile> pairContactFileList = pairContactFileRepository.findAll();
        assertThat(pairContactFileList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePairContactFile() throws Exception {
        // Initialize the database
        pairContactFileRepository.saveAndFlush(pairContactFile);

        int databaseSizeBeforeDelete = pairContactFileRepository.findAll().size();

        // Delete the pairContactFile
        restPairContactFileMockMvc.perform(delete("/api/pair-contact-files/{id}", pairContactFile.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PairContactFile> pairContactFileList = pairContactFileRepository.findAll();
        assertThat(pairContactFileList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
