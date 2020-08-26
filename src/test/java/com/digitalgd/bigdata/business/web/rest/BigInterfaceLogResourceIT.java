package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.BigdataBusinessApp;
import com.digitalgd.bigdata.business.domain.BigInterfaceLog;
import com.digitalgd.bigdata.business.repository.BigInterfaceLogRepository;
import com.digitalgd.bigdata.business.service.BigInterfaceLogService;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceLogDTO;
import com.digitalgd.bigdata.business.service.mapper.BigInterfaceLogMapper;

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
import java.util.UUID;

import static com.digitalgd.bigdata.business.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link BigInterfaceLogResource} REST controller.
 */
@SpringBootTest(classes = BigdataBusinessApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class BigInterfaceLogResourceIT {

    private static final UUID DEFAULT_PKID = UUID.randomUUID();
    private static final UUID UPDATED_PKID = UUID.randomUUID();

    private static final String DEFAULT_APP_KEY = "AAAAAAAAAA";
    private static final String UPDATED_APP_KEY = "BBBBBBBBBB";

    private static final String DEFAULT_CONSUMER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CONSUMER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_INTERFACE_ID = "AAAAAAAAAA";
    private static final String UPDATED_INTERFACE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_INTERFACE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_INTERFACE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_INTERFACE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_INTERFACE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DATA_PROV_IDS = "AAAAAAAAAA";
    private static final String UPDATED_DATA_PROV_IDS = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_USE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_USE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_INTERFACE_PATH = "AAAAAAAAAA";
    private static final String UPDATED_INTERFACE_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_GLOBAL_UNIQUE_ID = "AAAAAAAAAA";
    private static final String UPDATED_GLOBAL_UNIQUE_ID = "BBBBBBBBBB";

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

    @Autowired
    private BigInterfaceLogRepository bigInterfaceLogRepository;

    @Autowired
    private BigInterfaceLogMapper bigInterfaceLogMapper;

    @Autowired
    private BigInterfaceLogService bigInterfaceLogService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBigInterfaceLogMockMvc;

    private BigInterfaceLog bigInterfaceLog;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BigInterfaceLog createEntity(EntityManager em) {
        BigInterfaceLog bigInterfaceLog = new BigInterfaceLog()
            .pkid(DEFAULT_PKID)
            .appKey(DEFAULT_APP_KEY)
            .consumerName(DEFAULT_CONSUMER_NAME)
            .interfaceId(DEFAULT_INTERFACE_ID)
            .interfaceCode(DEFAULT_INTERFACE_CODE)
            .interfaceName(DEFAULT_INTERFACE_NAME)
            .dataProvIds(DEFAULT_DATA_PROV_IDS)
            .useTime(DEFAULT_USE_TIME)
            .status(DEFAULT_STATUS)
            .interfacePath(DEFAULT_INTERFACE_PATH)
            .globalUniqueId(DEFAULT_GLOBAL_UNIQUE_ID)
            .delFlag(DEFAULT_DEL_FLAG)
            .createTime(DEFAULT_CREATE_TIME)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createByOrgId(DEFAULT_CREATE_BY_ORG_ID)
            .createByOrgName(DEFAULT_CREATE_BY_ORG_NAME);
        return bigInterfaceLog;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BigInterfaceLog createUpdatedEntity(EntityManager em) {
        BigInterfaceLog bigInterfaceLog = new BigInterfaceLog()
            .pkid(UPDATED_PKID)
            .appKey(UPDATED_APP_KEY)
            .consumerName(UPDATED_CONSUMER_NAME)
            .interfaceId(UPDATED_INTERFACE_ID)
            .interfaceCode(UPDATED_INTERFACE_CODE)
            .interfaceName(UPDATED_INTERFACE_NAME)
            .dataProvIds(UPDATED_DATA_PROV_IDS)
            .useTime(UPDATED_USE_TIME)
            .status(UPDATED_STATUS)
            .interfacePath(UPDATED_INTERFACE_PATH)
            .globalUniqueId(UPDATED_GLOBAL_UNIQUE_ID)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME);
        return bigInterfaceLog;
    }

    @BeforeEach
    public void initTest() {
        bigInterfaceLog = createEntity(em);
    }

    @Test
    @Transactional
    public void createBigInterfaceLog() throws Exception {
        int databaseSizeBeforeCreate = bigInterfaceLogRepository.findAll().size();
        // Create the BigInterfaceLog
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);
        restBigInterfaceLogMockMvc.perform(post("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isCreated());

        // Validate the BigInterfaceLog in the database
        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeCreate + 1);
        BigInterfaceLog testBigInterfaceLog = bigInterfaceLogList.get(bigInterfaceLogList.size() - 1);
        assertThat(testBigInterfaceLog.getPkid()).isEqualTo(DEFAULT_PKID);
        assertThat(testBigInterfaceLog.getAppKey()).isEqualTo(DEFAULT_APP_KEY);
        assertThat(testBigInterfaceLog.getConsumerName()).isEqualTo(DEFAULT_CONSUMER_NAME);
        assertThat(testBigInterfaceLog.getInterfaceId()).isEqualTo(DEFAULT_INTERFACE_ID);
        assertThat(testBigInterfaceLog.getInterfaceCode()).isEqualTo(DEFAULT_INTERFACE_CODE);
        assertThat(testBigInterfaceLog.getInterfaceName()).isEqualTo(DEFAULT_INTERFACE_NAME);
        assertThat(testBigInterfaceLog.getDataProvIds()).isEqualTo(DEFAULT_DATA_PROV_IDS);
        assertThat(testBigInterfaceLog.getUseTime()).isEqualTo(DEFAULT_USE_TIME);
        assertThat(testBigInterfaceLog.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testBigInterfaceLog.getInterfacePath()).isEqualTo(DEFAULT_INTERFACE_PATH);
        assertThat(testBigInterfaceLog.getGlobalUniqueId()).isEqualTo(DEFAULT_GLOBAL_UNIQUE_ID);
        assertThat(testBigInterfaceLog.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testBigInterfaceLog.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testBigInterfaceLog.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testBigInterfaceLog.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testBigInterfaceLog.getCreateByOrgId()).isEqualTo(DEFAULT_CREATE_BY_ORG_ID);
        assertThat(testBigInterfaceLog.getCreateByOrgName()).isEqualTo(DEFAULT_CREATE_BY_ORG_NAME);
    }

    @Test
    @Transactional
    public void createBigInterfaceLogWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bigInterfaceLogRepository.findAll().size();

        // Create the BigInterfaceLog with an existing ID
        bigInterfaceLog.setId(1L);
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBigInterfaceLogMockMvc.perform(post("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BigInterfaceLog in the database
        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkConsumerNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceLogRepository.findAll().size();
        // set the field null
        bigInterfaceLog.setConsumerName(null);

        // Create the BigInterfaceLog, which fails.
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);


        restBigInterfaceLogMockMvc.perform(post("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkInterfaceIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceLogRepository.findAll().size();
        // set the field null
        bigInterfaceLog.setInterfaceId(null);

        // Create the BigInterfaceLog, which fails.
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);


        restBigInterfaceLogMockMvc.perform(post("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkInterfaceCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceLogRepository.findAll().size();
        // set the field null
        bigInterfaceLog.setInterfaceCode(null);

        // Create the BigInterfaceLog, which fails.
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);


        restBigInterfaceLogMockMvc.perform(post("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkInterfaceNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceLogRepository.findAll().size();
        // set the field null
        bigInterfaceLog.setInterfaceName(null);

        // Create the BigInterfaceLog, which fails.
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);


        restBigInterfaceLogMockMvc.perform(post("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDataProvIdsIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceLogRepository.findAll().size();
        // set the field null
        bigInterfaceLog.setDataProvIds(null);

        // Create the BigInterfaceLog, which fails.
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);


        restBigInterfaceLogMockMvc.perform(post("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceLogRepository.findAll().size();
        // set the field null
        bigInterfaceLog.setDelFlag(null);

        // Create the BigInterfaceLog, which fails.
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);


        restBigInterfaceLogMockMvc.perform(post("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceLogRepository.findAll().size();
        // set the field null
        bigInterfaceLog.setCreateById(null);

        // Create the BigInterfaceLog, which fails.
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);


        restBigInterfaceLogMockMvc.perform(post("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceLogRepository.findAll().size();
        // set the field null
        bigInterfaceLog.setCreateByName(null);

        // Create the BigInterfaceLog, which fails.
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);


        restBigInterfaceLogMockMvc.perform(post("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByOrgIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceLogRepository.findAll().size();
        // set the field null
        bigInterfaceLog.setCreateByOrgId(null);

        // Create the BigInterfaceLog, which fails.
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);


        restBigInterfaceLogMockMvc.perform(post("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBigInterfaceLogs() throws Exception {
        // Initialize the database
        bigInterfaceLogRepository.saveAndFlush(bigInterfaceLog);

        // Get all the bigInterfaceLogList
        restBigInterfaceLogMockMvc.perform(get("/api/big-interface-logs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bigInterfaceLog.getId().intValue())))
            .andExpect(jsonPath("$.[*].pkid").value(hasItem(DEFAULT_PKID.toString())))
            .andExpect(jsonPath("$.[*].appKey").value(hasItem(DEFAULT_APP_KEY)))
            .andExpect(jsonPath("$.[*].consumerName").value(hasItem(DEFAULT_CONSUMER_NAME)))
            .andExpect(jsonPath("$.[*].interfaceId").value(hasItem(DEFAULT_INTERFACE_ID)))
            .andExpect(jsonPath("$.[*].interfaceCode").value(hasItem(DEFAULT_INTERFACE_CODE)))
            .andExpect(jsonPath("$.[*].interfaceName").value(hasItem(DEFAULT_INTERFACE_NAME)))
            .andExpect(jsonPath("$.[*].dataProvIds").value(hasItem(DEFAULT_DATA_PROV_IDS)))
            .andExpect(jsonPath("$.[*].useTime").value(hasItem(sameInstant(DEFAULT_USE_TIME))))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].interfacePath").value(hasItem(DEFAULT_INTERFACE_PATH)))
            .andExpect(jsonPath("$.[*].globalUniqueId").value(hasItem(DEFAULT_GLOBAL_UNIQUE_ID)))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG.booleanValue())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(sameInstant(DEFAULT_CREATE_TIME))))
            .andExpect(jsonPath("$.[*].createById").value(hasItem(DEFAULT_CREATE_BY_ID)))
            .andExpect(jsonPath("$.[*].createByName").value(hasItem(DEFAULT_CREATE_BY_NAME)))
            .andExpect(jsonPath("$.[*].createByOrgId").value(hasItem(DEFAULT_CREATE_BY_ORG_ID)))
            .andExpect(jsonPath("$.[*].createByOrgName").value(hasItem(DEFAULT_CREATE_BY_ORG_NAME)));
    }
    
    @Test
    @Transactional
    public void getBigInterfaceLog() throws Exception {
        // Initialize the database
        bigInterfaceLogRepository.saveAndFlush(bigInterfaceLog);

        // Get the bigInterfaceLog
        restBigInterfaceLogMockMvc.perform(get("/api/big-interface-logs/{id}", bigInterfaceLog.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(bigInterfaceLog.getId().intValue()))
            .andExpect(jsonPath("$.pkid").value(DEFAULT_PKID.toString()))
            .andExpect(jsonPath("$.appKey").value(DEFAULT_APP_KEY))
            .andExpect(jsonPath("$.consumerName").value(DEFAULT_CONSUMER_NAME))
            .andExpect(jsonPath("$.interfaceId").value(DEFAULT_INTERFACE_ID))
            .andExpect(jsonPath("$.interfaceCode").value(DEFAULT_INTERFACE_CODE))
            .andExpect(jsonPath("$.interfaceName").value(DEFAULT_INTERFACE_NAME))
            .andExpect(jsonPath("$.dataProvIds").value(DEFAULT_DATA_PROV_IDS))
            .andExpect(jsonPath("$.useTime").value(sameInstant(DEFAULT_USE_TIME)))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.interfacePath").value(DEFAULT_INTERFACE_PATH))
            .andExpect(jsonPath("$.globalUniqueId").value(DEFAULT_GLOBAL_UNIQUE_ID))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG.booleanValue()))
            .andExpect(jsonPath("$.createTime").value(sameInstant(DEFAULT_CREATE_TIME)))
            .andExpect(jsonPath("$.createById").value(DEFAULT_CREATE_BY_ID))
            .andExpect(jsonPath("$.createByName").value(DEFAULT_CREATE_BY_NAME))
            .andExpect(jsonPath("$.createByOrgId").value(DEFAULT_CREATE_BY_ORG_ID))
            .andExpect(jsonPath("$.createByOrgName").value(DEFAULT_CREATE_BY_ORG_NAME));
    }
    @Test
    @Transactional
    public void getNonExistingBigInterfaceLog() throws Exception {
        // Get the bigInterfaceLog
        restBigInterfaceLogMockMvc.perform(get("/api/big-interface-logs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBigInterfaceLog() throws Exception {
        // Initialize the database
        bigInterfaceLogRepository.saveAndFlush(bigInterfaceLog);

        int databaseSizeBeforeUpdate = bigInterfaceLogRepository.findAll().size();

        // Update the bigInterfaceLog
        BigInterfaceLog updatedBigInterfaceLog = bigInterfaceLogRepository.findById(bigInterfaceLog.getId()).get();
        // Disconnect from session so that the updates on updatedBigInterfaceLog are not directly saved in db
        em.detach(updatedBigInterfaceLog);
        updatedBigInterfaceLog
            .pkid(UPDATED_PKID)
            .appKey(UPDATED_APP_KEY)
            .consumerName(UPDATED_CONSUMER_NAME)
            .interfaceId(UPDATED_INTERFACE_ID)
            .interfaceCode(UPDATED_INTERFACE_CODE)
            .interfaceName(UPDATED_INTERFACE_NAME)
            .dataProvIds(UPDATED_DATA_PROV_IDS)
            .useTime(UPDATED_USE_TIME)
            .status(UPDATED_STATUS)
            .interfacePath(UPDATED_INTERFACE_PATH)
            .globalUniqueId(UPDATED_GLOBAL_UNIQUE_ID)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME);
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(updatedBigInterfaceLog);

        restBigInterfaceLogMockMvc.perform(put("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isOk());

        // Validate the BigInterfaceLog in the database
        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeUpdate);
        BigInterfaceLog testBigInterfaceLog = bigInterfaceLogList.get(bigInterfaceLogList.size() - 1);
        assertThat(testBigInterfaceLog.getPkid()).isEqualTo(UPDATED_PKID);
        assertThat(testBigInterfaceLog.getAppKey()).isEqualTo(UPDATED_APP_KEY);
        assertThat(testBigInterfaceLog.getConsumerName()).isEqualTo(UPDATED_CONSUMER_NAME);
        assertThat(testBigInterfaceLog.getInterfaceId()).isEqualTo(UPDATED_INTERFACE_ID);
        assertThat(testBigInterfaceLog.getInterfaceCode()).isEqualTo(UPDATED_INTERFACE_CODE);
        assertThat(testBigInterfaceLog.getInterfaceName()).isEqualTo(UPDATED_INTERFACE_NAME);
        assertThat(testBigInterfaceLog.getDataProvIds()).isEqualTo(UPDATED_DATA_PROV_IDS);
        assertThat(testBigInterfaceLog.getUseTime()).isEqualTo(UPDATED_USE_TIME);
        assertThat(testBigInterfaceLog.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testBigInterfaceLog.getInterfacePath()).isEqualTo(UPDATED_INTERFACE_PATH);
        assertThat(testBigInterfaceLog.getGlobalUniqueId()).isEqualTo(UPDATED_GLOBAL_UNIQUE_ID);
        assertThat(testBigInterfaceLog.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testBigInterfaceLog.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testBigInterfaceLog.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testBigInterfaceLog.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testBigInterfaceLog.getCreateByOrgId()).isEqualTo(UPDATED_CREATE_BY_ORG_ID);
        assertThat(testBigInterfaceLog.getCreateByOrgName()).isEqualTo(UPDATED_CREATE_BY_ORG_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingBigInterfaceLog() throws Exception {
        int databaseSizeBeforeUpdate = bigInterfaceLogRepository.findAll().size();

        // Create the BigInterfaceLog
        BigInterfaceLogDTO bigInterfaceLogDTO = bigInterfaceLogMapper.toDto(bigInterfaceLog);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBigInterfaceLogMockMvc.perform(put("/api/big-interface-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceLogDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BigInterfaceLog in the database
        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBigInterfaceLog() throws Exception {
        // Initialize the database
        bigInterfaceLogRepository.saveAndFlush(bigInterfaceLog);

        int databaseSizeBeforeDelete = bigInterfaceLogRepository.findAll().size();

        // Delete the bigInterfaceLog
        restBigInterfaceLogMockMvc.perform(delete("/api/big-interface-logs/{id}", bigInterfaceLog.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BigInterfaceLog> bigInterfaceLogList = bigInterfaceLogRepository.findAll();
        assertThat(bigInterfaceLogList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
