package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.BigdataBusinessApp;
import com.digitalgd.bigdata.business.domain.BigInterfaceBiz;
import com.digitalgd.bigdata.business.repository.BigInterfaceBizRepository;
import com.digitalgd.bigdata.business.service.BigInterfaceBizService;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceBizDTO;
import com.digitalgd.bigdata.business.service.mapper.BigInterfaceBizMapper;

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
 * Integration tests for the {@link BigInterfaceBizResource} REST controller.
 */
@SpringBootTest(classes = BigdataBusinessApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class BigInterfaceBizResourceIT {

    private static final String DEFAULT_PKID = "AAAAAAAAAA";
    private static final String UPDATED_PKID = "BBBBBBBBBB";

    private static final String DEFAULT_INTERFACE_ID = "AAAAAAAAAA";
    private static final String UPDATED_INTERFACE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_BIZ_ID = "AAAAAAAAAA";
    private static final String UPDATED_BIZ_ID = "BBBBBBBBBB";

    private static final Boolean DEFAULT_DEL_FLAG = false;
    private static final Boolean UPDATED_DEL_FLAG = true;

    private static final ZonedDateTime DEFAULT_CREATE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_CREATE_BY_ID = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_BY_ID = "BBBBBBBBBB";

    private static final String DEFAULT_CREATE_BY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_BY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CREATE_BY_ORG_ID = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_BY_ORG_ID = "BBBBBBBBBB";

    private static final String DEFAULT_CREATE_BY_ORG_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_BY_ORG_NAME = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_LAST_UP_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_LAST_UP_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_LAST_UP_ID = "AAAAAAAAAA";
    private static final String UPDATED_LAST_UP_ID = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_UP_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LAST_UP_NAME = "BBBBBBBBBB";

    @Autowired
    private BigInterfaceBizRepository bigInterfaceBizRepository;

    @Autowired
    private BigInterfaceBizMapper bigInterfaceBizMapper;

    @Autowired
    private BigInterfaceBizService bigInterfaceBizService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBigInterfaceBizMockMvc;

    private BigInterfaceBiz bigInterfaceBiz;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BigInterfaceBiz createEntity(EntityManager em) {
        BigInterfaceBiz bigInterfaceBiz = new BigInterfaceBiz()
            .pkid(DEFAULT_PKID)
            .interfaceId(DEFAULT_INTERFACE_ID)
            .bizId(DEFAULT_BIZ_ID)
            .delFlag(DEFAULT_DEL_FLAG)
            .createTime(DEFAULT_CREATE_TIME)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createByOrgId(DEFAULT_CREATE_BY_ORG_ID)
            .createByOrgName(DEFAULT_CREATE_BY_ORG_NAME)
            .lastUpTime(DEFAULT_LAST_UP_TIME)
            .lastUpId(DEFAULT_LAST_UP_ID)
            .lastUpName(DEFAULT_LAST_UP_NAME);
        return bigInterfaceBiz;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BigInterfaceBiz createUpdatedEntity(EntityManager em) {
        BigInterfaceBiz bigInterfaceBiz = new BigInterfaceBiz()
            .pkid(UPDATED_PKID)
            .interfaceId(UPDATED_INTERFACE_ID)
            .bizId(UPDATED_BIZ_ID)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        return bigInterfaceBiz;
    }

    @BeforeEach
    public void initTest() {
        bigInterfaceBiz = createEntity(em);
    }

    @Test
    @Transactional
    public void createBigInterfaceBiz() throws Exception {
        int databaseSizeBeforeCreate = bigInterfaceBizRepository.findAll().size();
        // Create the BigInterfaceBiz
        BigInterfaceBizDTO bigInterfaceBizDTO = bigInterfaceBizMapper.toDto(bigInterfaceBiz);
        restBigInterfaceBizMockMvc.perform(post("/api/big-interface-bizs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceBizDTO)))
            .andExpect(status().isCreated());

        // Validate the BigInterfaceBiz in the database
        List<BigInterfaceBiz> bigInterfaceBizList = bigInterfaceBizRepository.findAll();
        assertThat(bigInterfaceBizList).hasSize(databaseSizeBeforeCreate + 1);
        BigInterfaceBiz testBigInterfaceBiz = bigInterfaceBizList.get(bigInterfaceBizList.size() - 1);
        assertThat(testBigInterfaceBiz.getPkid()).isEqualTo(DEFAULT_PKID);
        assertThat(testBigInterfaceBiz.getInterfaceId()).isEqualTo(DEFAULT_INTERFACE_ID);
        assertThat(testBigInterfaceBiz.getBizId()).isEqualTo(DEFAULT_BIZ_ID);
        assertThat(testBigInterfaceBiz.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testBigInterfaceBiz.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testBigInterfaceBiz.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testBigInterfaceBiz.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testBigInterfaceBiz.getCreateByOrgId()).isEqualTo(DEFAULT_CREATE_BY_ORG_ID);
        assertThat(testBigInterfaceBiz.getCreateByOrgName()).isEqualTo(DEFAULT_CREATE_BY_ORG_NAME);
        assertThat(testBigInterfaceBiz.getLastUpTime()).isEqualTo(DEFAULT_LAST_UP_TIME);
        assertThat(testBigInterfaceBiz.getLastUpId()).isEqualTo(DEFAULT_LAST_UP_ID);
        assertThat(testBigInterfaceBiz.getLastUpName()).isEqualTo(DEFAULT_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void createBigInterfaceBizWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bigInterfaceBizRepository.findAll().size();

        // Create the BigInterfaceBiz with an existing ID
        bigInterfaceBiz.setId(1L);
        BigInterfaceBizDTO bigInterfaceBizDTO = bigInterfaceBizMapper.toDto(bigInterfaceBiz);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBigInterfaceBizMockMvc.perform(post("/api/big-interface-bizs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceBizDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BigInterfaceBiz in the database
        List<BigInterfaceBiz> bigInterfaceBizList = bigInterfaceBizRepository.findAll();
        assertThat(bigInterfaceBizList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkInterfaceIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceBizRepository.findAll().size();
        // set the field null
        bigInterfaceBiz.setInterfaceId(null);

        // Create the BigInterfaceBiz, which fails.
        BigInterfaceBizDTO bigInterfaceBizDTO = bigInterfaceBizMapper.toDto(bigInterfaceBiz);


        restBigInterfaceBizMockMvc.perform(post("/api/big-interface-bizs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceBizDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceBiz> bigInterfaceBizList = bigInterfaceBizRepository.findAll();
        assertThat(bigInterfaceBizList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkBizIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceBizRepository.findAll().size();
        // set the field null
        bigInterfaceBiz.setBizId(null);

        // Create the BigInterfaceBiz, which fails.
        BigInterfaceBizDTO bigInterfaceBizDTO = bigInterfaceBizMapper.toDto(bigInterfaceBiz);


        restBigInterfaceBizMockMvc.perform(post("/api/big-interface-bizs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceBizDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceBiz> bigInterfaceBizList = bigInterfaceBizRepository.findAll();
        assertThat(bigInterfaceBizList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceBizRepository.findAll().size();
        // set the field null
        bigInterfaceBiz.setDelFlag(null);

        // Create the BigInterfaceBiz, which fails.
        BigInterfaceBizDTO bigInterfaceBizDTO = bigInterfaceBizMapper.toDto(bigInterfaceBiz);


        restBigInterfaceBizMockMvc.perform(post("/api/big-interface-bizs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceBizDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceBiz> bigInterfaceBizList = bigInterfaceBizRepository.findAll();
        assertThat(bigInterfaceBizList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceBizRepository.findAll().size();
        // set the field null
        bigInterfaceBiz.setCreateById(null);

        // Create the BigInterfaceBiz, which fails.
        BigInterfaceBizDTO bigInterfaceBizDTO = bigInterfaceBizMapper.toDto(bigInterfaceBiz);


        restBigInterfaceBizMockMvc.perform(post("/api/big-interface-bizs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceBizDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceBiz> bigInterfaceBizList = bigInterfaceBizRepository.findAll();
        assertThat(bigInterfaceBizList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceBizRepository.findAll().size();
        // set the field null
        bigInterfaceBiz.setCreateByName(null);

        // Create the BigInterfaceBiz, which fails.
        BigInterfaceBizDTO bigInterfaceBizDTO = bigInterfaceBizMapper.toDto(bigInterfaceBiz);


        restBigInterfaceBizMockMvc.perform(post("/api/big-interface-bizs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceBizDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceBiz> bigInterfaceBizList = bigInterfaceBizRepository.findAll();
        assertThat(bigInterfaceBizList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByOrgIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceBizRepository.findAll().size();
        // set the field null
        bigInterfaceBiz.setCreateByOrgId(null);

        // Create the BigInterfaceBiz, which fails.
        BigInterfaceBizDTO bigInterfaceBizDTO = bigInterfaceBizMapper.toDto(bigInterfaceBiz);


        restBigInterfaceBizMockMvc.perform(post("/api/big-interface-bizs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceBizDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceBiz> bigInterfaceBizList = bigInterfaceBizRepository.findAll();
        assertThat(bigInterfaceBizList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBigInterfaceBizs() throws Exception {
        // Initialize the database
        bigInterfaceBizRepository.saveAndFlush(bigInterfaceBiz);

        // Get all the bigInterfaceBizList
        restBigInterfaceBizMockMvc.perform(get("/api/big-interface-bizs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bigInterfaceBiz.getId().intValue())))
            .andExpect(jsonPath("$.[*].pkid").value(hasItem(DEFAULT_PKID)))
            .andExpect(jsonPath("$.[*].interfaceId").value(hasItem(DEFAULT_INTERFACE_ID)))
            .andExpect(jsonPath("$.[*].bizId").value(hasItem(DEFAULT_BIZ_ID)))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG.booleanValue())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(sameInstant(DEFAULT_CREATE_TIME))))
            .andExpect(jsonPath("$.[*].createById").value(hasItem(DEFAULT_CREATE_BY_ID)))
            .andExpect(jsonPath("$.[*].createByName").value(hasItem(DEFAULT_CREATE_BY_NAME)))
            .andExpect(jsonPath("$.[*].createByOrgId").value(hasItem(DEFAULT_CREATE_BY_ORG_ID)))
            .andExpect(jsonPath("$.[*].createByOrgName").value(hasItem(DEFAULT_CREATE_BY_ORG_NAME)))
            .andExpect(jsonPath("$.[*].lastUpTime").value(hasItem(sameInstant(DEFAULT_LAST_UP_TIME))))
            .andExpect(jsonPath("$.[*].lastUpId").value(hasItem(DEFAULT_LAST_UP_ID)))
            .andExpect(jsonPath("$.[*].lastUpName").value(hasItem(DEFAULT_LAST_UP_NAME)));
    }
    
    @Test
    @Transactional
    public void getBigInterfaceBiz() throws Exception {
        // Initialize the database
        bigInterfaceBizRepository.saveAndFlush(bigInterfaceBiz);

        // Get the bigInterfaceBiz
        restBigInterfaceBizMockMvc.perform(get("/api/big-interface-bizs/{id}", bigInterfaceBiz.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(bigInterfaceBiz.getId().intValue()))
            .andExpect(jsonPath("$.pkid").value(DEFAULT_PKID))
            .andExpect(jsonPath("$.interfaceId").value(DEFAULT_INTERFACE_ID))
            .andExpect(jsonPath("$.bizId").value(DEFAULT_BIZ_ID))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG.booleanValue()))
            .andExpect(jsonPath("$.createTime").value(sameInstant(DEFAULT_CREATE_TIME)))
            .andExpect(jsonPath("$.createById").value(DEFAULT_CREATE_BY_ID))
            .andExpect(jsonPath("$.createByName").value(DEFAULT_CREATE_BY_NAME))
            .andExpect(jsonPath("$.createByOrgId").value(DEFAULT_CREATE_BY_ORG_ID))
            .andExpect(jsonPath("$.createByOrgName").value(DEFAULT_CREATE_BY_ORG_NAME))
            .andExpect(jsonPath("$.lastUpTime").value(sameInstant(DEFAULT_LAST_UP_TIME)))
            .andExpect(jsonPath("$.lastUpId").value(DEFAULT_LAST_UP_ID))
            .andExpect(jsonPath("$.lastUpName").value(DEFAULT_LAST_UP_NAME));
    }
    @Test
    @Transactional
    public void getNonExistingBigInterfaceBiz() throws Exception {
        // Get the bigInterfaceBiz
        restBigInterfaceBizMockMvc.perform(get("/api/big-interface-bizs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBigInterfaceBiz() throws Exception {
        // Initialize the database
        bigInterfaceBizRepository.saveAndFlush(bigInterfaceBiz);

        int databaseSizeBeforeUpdate = bigInterfaceBizRepository.findAll().size();

        // Update the bigInterfaceBiz
        BigInterfaceBiz updatedBigInterfaceBiz = bigInterfaceBizRepository.findById(bigInterfaceBiz.getId()).get();
        // Disconnect from session so that the updates on updatedBigInterfaceBiz are not directly saved in db
        em.detach(updatedBigInterfaceBiz);
        updatedBigInterfaceBiz
            .pkid(UPDATED_PKID)
            .interfaceId(UPDATED_INTERFACE_ID)
            .bizId(UPDATED_BIZ_ID)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        BigInterfaceBizDTO bigInterfaceBizDTO = bigInterfaceBizMapper.toDto(updatedBigInterfaceBiz);

        restBigInterfaceBizMockMvc.perform(put("/api/big-interface-bizs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceBizDTO)))
            .andExpect(status().isOk());

        // Validate the BigInterfaceBiz in the database
        List<BigInterfaceBiz> bigInterfaceBizList = bigInterfaceBizRepository.findAll();
        assertThat(bigInterfaceBizList).hasSize(databaseSizeBeforeUpdate);
        BigInterfaceBiz testBigInterfaceBiz = bigInterfaceBizList.get(bigInterfaceBizList.size() - 1);
        assertThat(testBigInterfaceBiz.getPkid()).isEqualTo(UPDATED_PKID);
        assertThat(testBigInterfaceBiz.getInterfaceId()).isEqualTo(UPDATED_INTERFACE_ID);
        assertThat(testBigInterfaceBiz.getBizId()).isEqualTo(UPDATED_BIZ_ID);
        assertThat(testBigInterfaceBiz.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testBigInterfaceBiz.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testBigInterfaceBiz.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testBigInterfaceBiz.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testBigInterfaceBiz.getCreateByOrgId()).isEqualTo(UPDATED_CREATE_BY_ORG_ID);
        assertThat(testBigInterfaceBiz.getCreateByOrgName()).isEqualTo(UPDATED_CREATE_BY_ORG_NAME);
        assertThat(testBigInterfaceBiz.getLastUpTime()).isEqualTo(UPDATED_LAST_UP_TIME);
        assertThat(testBigInterfaceBiz.getLastUpId()).isEqualTo(UPDATED_LAST_UP_ID);
        assertThat(testBigInterfaceBiz.getLastUpName()).isEqualTo(UPDATED_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingBigInterfaceBiz() throws Exception {
        int databaseSizeBeforeUpdate = bigInterfaceBizRepository.findAll().size();

        // Create the BigInterfaceBiz
        BigInterfaceBizDTO bigInterfaceBizDTO = bigInterfaceBizMapper.toDto(bigInterfaceBiz);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBigInterfaceBizMockMvc.perform(put("/api/big-interface-bizs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceBizDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BigInterfaceBiz in the database
        List<BigInterfaceBiz> bigInterfaceBizList = bigInterfaceBizRepository.findAll();
        assertThat(bigInterfaceBizList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBigInterfaceBiz() throws Exception {
        // Initialize the database
        bigInterfaceBizRepository.saveAndFlush(bigInterfaceBiz);

        int databaseSizeBeforeDelete = bigInterfaceBizRepository.findAll().size();

        // Delete the bigInterfaceBiz
        restBigInterfaceBizMockMvc.perform(delete("/api/big-interface-bizs/{id}", bigInterfaceBiz.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BigInterfaceBiz> bigInterfaceBizList = bigInterfaceBizRepository.findAll();
        assertThat(bigInterfaceBizList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
