package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.BigdataBusinessApp;
import com.digitalgd.bigdata.business.domain.PairContract;
import com.digitalgd.bigdata.business.repository.PairContractRepository;
import com.digitalgd.bigdata.business.service.PairContractService;
import com.digitalgd.bigdata.business.service.dto.PairContractDTO;
import com.digitalgd.bigdata.business.service.mapper.PairContractMapper;

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
 * Integration tests for the {@link PairContractResource} REST controller.
 */
@SpringBootTest(classes = BigdataBusinessApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class PairContractResourceIT {

    private static final String DEFAULT_CONTRACT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CONTRACT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CONTRACT_CODE = "AAAAAA";
    private static final String UPDATED_CONTRACT_CODE = "BBBBBB";

    private static final String DEFAULT_CONTRACT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_CONTRACT_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_CONTRACT_DESC = "AAAAAAAAAA";
    private static final String UPDATED_CONTRACT_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_DATA_PROV_IDS = "AAAAAAAAAA";
    private static final String UPDATED_DATA_PROV_IDS = "BBBBBBBBBB";

    private static final String DEFAULT_DATA_PROV_NAMES = "AAAAAAAAAA";
    private static final String UPDATED_DATA_PROV_NAMES = "BBBBBBBBBB";

    private static final String DEFAULT_CONSUMER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CONSUMER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CONSUMER_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CONSUMER_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_APP_KEY = "AAAAAAAAAA";
    private static final String UPDATED_APP_KEY = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_START_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_START_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_END_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_END_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_PUBLIC_KEY = "AAAAAAAAAA";
    private static final String UPDATED_PUBLIC_KEY = "BBBBBBBBBB";

    private static final String DEFAULT_PRIVATE_KEY = "AAAAAAAAAA";
    private static final String UPDATED_PRIVATE_KEY = "BBBBBBBBBB";

    private static final String DEFAULT_REDIRECT_URL = "AAAAAAAAAA";
    private static final String UPDATED_REDIRECT_URL = "BBBBBBBBBB";

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
    private PairContractRepository pairContractRepository;

    @Autowired
    private PairContractMapper pairContractMapper;

    @Autowired
    private PairContractService pairContractService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPairContractMockMvc;

    private PairContract pairContract;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PairContract createEntity(EntityManager em) {
        PairContract pairContract = new PairContract()
            .contractName(DEFAULT_CONTRACT_NAME)
            .contractCode(DEFAULT_CONTRACT_CODE)
            .contractStatus(DEFAULT_CONTRACT_STATUS)
            .contractDesc(DEFAULT_CONTRACT_DESC)
            .dataProvIds(DEFAULT_DATA_PROV_IDS)
            .dataProvNames(DEFAULT_DATA_PROV_NAMES)
            .consumerName(DEFAULT_CONSUMER_NAME)
            .consumerCode(DEFAULT_CONSUMER_CODE)
            .appKey(DEFAULT_APP_KEY)
            .startTime(DEFAULT_START_TIME)
            .endTime(DEFAULT_END_TIME)
            .publicKey(DEFAULT_PUBLIC_KEY)
            .privateKey(DEFAULT_PRIVATE_KEY)
            .redirectUrl(DEFAULT_REDIRECT_URL)
            .delFlag(DEFAULT_DEL_FLAG)
            .createTime(DEFAULT_CREATE_TIME)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createByOrgId(DEFAULT_CREATE_BY_ORG_ID)
            .createByOrgName(DEFAULT_CREATE_BY_ORG_NAME)
            .lastUpTime(DEFAULT_LAST_UP_TIME)
            .lastUpId(DEFAULT_LAST_UP_ID)
            .lastUpName(DEFAULT_LAST_UP_NAME);
        return pairContract;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PairContract createUpdatedEntity(EntityManager em) {
        PairContract pairContract = new PairContract()
            .contractName(UPDATED_CONTRACT_NAME)
            .contractCode(UPDATED_CONTRACT_CODE)
            .contractStatus(UPDATED_CONTRACT_STATUS)
            .contractDesc(UPDATED_CONTRACT_DESC)
            .dataProvIds(UPDATED_DATA_PROV_IDS)
            .dataProvNames(UPDATED_DATA_PROV_NAMES)
            .consumerName(UPDATED_CONSUMER_NAME)
            .consumerCode(UPDATED_CONSUMER_CODE)
            .appKey(UPDATED_APP_KEY)
            .startTime(UPDATED_START_TIME)
            .endTime(UPDATED_END_TIME)
            .publicKey(UPDATED_PUBLIC_KEY)
            .privateKey(UPDATED_PRIVATE_KEY)
            .redirectUrl(UPDATED_REDIRECT_URL)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        return pairContract;
    }

    @BeforeEach
    public void initTest() {
        pairContract = createEntity(em);
    }

    @Test
    @Transactional
    public void createPairContract() throws Exception {
        int databaseSizeBeforeCreate = pairContractRepository.findAll().size();
        // Create the PairContract
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);
        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isCreated());

        // Validate the PairContract in the database
        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeCreate + 1);
        PairContract testPairContract = pairContractList.get(pairContractList.size() - 1);
        assertThat(testPairContract.getContractName()).isEqualTo(DEFAULT_CONTRACT_NAME);
        assertThat(testPairContract.getContractCode()).isEqualTo(DEFAULT_CONTRACT_CODE);
        assertThat(testPairContract.getContractStatus()).isEqualTo(DEFAULT_CONTRACT_STATUS);
        assertThat(testPairContract.getContractDesc()).isEqualTo(DEFAULT_CONTRACT_DESC);
        assertThat(testPairContract.getDataProvIds()).isEqualTo(DEFAULT_DATA_PROV_IDS);
        assertThat(testPairContract.getDataProvNames()).isEqualTo(DEFAULT_DATA_PROV_NAMES);
        assertThat(testPairContract.getConsumerName()).isEqualTo(DEFAULT_CONSUMER_NAME);
        assertThat(testPairContract.getConsumerCode()).isEqualTo(DEFAULT_CONSUMER_CODE);
        assertThat(testPairContract.getAppKey()).isEqualTo(DEFAULT_APP_KEY);
        assertThat(testPairContract.getStartTime()).isEqualTo(DEFAULT_START_TIME);
        assertThat(testPairContract.getEndTime()).isEqualTo(DEFAULT_END_TIME);
        assertThat(testPairContract.getPublicKey()).isEqualTo(DEFAULT_PUBLIC_KEY);
        assertThat(testPairContract.getPrivateKey()).isEqualTo(DEFAULT_PRIVATE_KEY);
        assertThat(testPairContract.getRedirectUrl()).isEqualTo(DEFAULT_REDIRECT_URL);
        assertThat(testPairContract.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testPairContract.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testPairContract.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testPairContract.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testPairContract.getCreateByOrgId()).isEqualTo(DEFAULT_CREATE_BY_ORG_ID);
        assertThat(testPairContract.getCreateByOrgName()).isEqualTo(DEFAULT_CREATE_BY_ORG_NAME);
        assertThat(testPairContract.getLastUpTime()).isEqualTo(DEFAULT_LAST_UP_TIME);
        assertThat(testPairContract.getLastUpId()).isEqualTo(DEFAULT_LAST_UP_ID);
        assertThat(testPairContract.getLastUpName()).isEqualTo(DEFAULT_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void createPairContractWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = pairContractRepository.findAll().size();

        // Create the PairContract with an existing ID
        pairContract.setId(1L);
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PairContract in the database
        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkContractNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractRepository.findAll().size();
        // set the field null
        pairContract.setContractName(null);

        // Create the PairContract, which fails.
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);


        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkContractCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractRepository.findAll().size();
        // set the field null
        pairContract.setContractCode(null);

        // Create the PairContract, which fails.
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);


        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkContractStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractRepository.findAll().size();
        // set the field null
        pairContract.setContractStatus(null);

        // Create the PairContract, which fails.
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);


        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDataProvIdsIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractRepository.findAll().size();
        // set the field null
        pairContract.setDataProvIds(null);

        // Create the PairContract, which fails.
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);


        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDataProvNamesIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractRepository.findAll().size();
        // set the field null
        pairContract.setDataProvNames(null);

        // Create the PairContract, which fails.
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);


        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkConsumerNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractRepository.findAll().size();
        // set the field null
        pairContract.setConsumerName(null);

        // Create the PairContract, which fails.
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);


        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkConsumerCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractRepository.findAll().size();
        // set the field null
        pairContract.setConsumerCode(null);

        // Create the PairContract, which fails.
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);


        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractRepository.findAll().size();
        // set the field null
        pairContract.setDelFlag(null);

        // Create the PairContract, which fails.
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);


        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractRepository.findAll().size();
        // set the field null
        pairContract.setCreateById(null);

        // Create the PairContract, which fails.
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);


        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractRepository.findAll().size();
        // set the field null
        pairContract.setCreateByName(null);

        // Create the PairContract, which fails.
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);


        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByOrgIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = pairContractRepository.findAll().size();
        // set the field null
        pairContract.setCreateByOrgId(null);

        // Create the PairContract, which fails.
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);


        restPairContractMockMvc.perform(post("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllPairContracts() throws Exception {
        // Initialize the database
        pairContractRepository.saveAndFlush(pairContract);

        // Get all the pairContractList
        restPairContractMockMvc.perform(get("/api/pair-contracts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(pairContract.getId().intValue())))
            .andExpect(jsonPath("$.[*].contractName").value(hasItem(DEFAULT_CONTRACT_NAME)))
            .andExpect(jsonPath("$.[*].contractCode").value(hasItem(DEFAULT_CONTRACT_CODE)))
            .andExpect(jsonPath("$.[*].contractStatus").value(hasItem(DEFAULT_CONTRACT_STATUS)))
            .andExpect(jsonPath("$.[*].contractDesc").value(hasItem(DEFAULT_CONTRACT_DESC)))
            .andExpect(jsonPath("$.[*].dataProvIds").value(hasItem(DEFAULT_DATA_PROV_IDS)))
            .andExpect(jsonPath("$.[*].dataProvNames").value(hasItem(DEFAULT_DATA_PROV_NAMES)))
            .andExpect(jsonPath("$.[*].consumerName").value(hasItem(DEFAULT_CONSUMER_NAME)))
            .andExpect(jsonPath("$.[*].consumerCode").value(hasItem(DEFAULT_CONSUMER_CODE)))
            .andExpect(jsonPath("$.[*].appKey").value(hasItem(DEFAULT_APP_KEY)))
            .andExpect(jsonPath("$.[*].startTime").value(hasItem(sameInstant(DEFAULT_START_TIME))))
            .andExpect(jsonPath("$.[*].endTime").value(hasItem(sameInstant(DEFAULT_END_TIME))))
            .andExpect(jsonPath("$.[*].publicKey").value(hasItem(DEFAULT_PUBLIC_KEY)))
            .andExpect(jsonPath("$.[*].privateKey").value(hasItem(DEFAULT_PRIVATE_KEY)))
            .andExpect(jsonPath("$.[*].redirectUrl").value(hasItem(DEFAULT_REDIRECT_URL)))
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
    public void getPairContract() throws Exception {
        // Initialize the database
        pairContractRepository.saveAndFlush(pairContract);

        // Get the pairContract
        restPairContractMockMvc.perform(get("/api/pair-contracts/{id}", pairContract.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(pairContract.getId().intValue()))
            .andExpect(jsonPath("$.contractName").value(DEFAULT_CONTRACT_NAME))
            .andExpect(jsonPath("$.contractCode").value(DEFAULT_CONTRACT_CODE))
            .andExpect(jsonPath("$.contractStatus").value(DEFAULT_CONTRACT_STATUS))
            .andExpect(jsonPath("$.contractDesc").value(DEFAULT_CONTRACT_DESC))
            .andExpect(jsonPath("$.dataProvIds").value(DEFAULT_DATA_PROV_IDS))
            .andExpect(jsonPath("$.dataProvNames").value(DEFAULT_DATA_PROV_NAMES))
            .andExpect(jsonPath("$.consumerName").value(DEFAULT_CONSUMER_NAME))
            .andExpect(jsonPath("$.consumerCode").value(DEFAULT_CONSUMER_CODE))
            .andExpect(jsonPath("$.appKey").value(DEFAULT_APP_KEY))
            .andExpect(jsonPath("$.startTime").value(sameInstant(DEFAULT_START_TIME)))
            .andExpect(jsonPath("$.endTime").value(sameInstant(DEFAULT_END_TIME)))
            .andExpect(jsonPath("$.publicKey").value(DEFAULT_PUBLIC_KEY))
            .andExpect(jsonPath("$.privateKey").value(DEFAULT_PRIVATE_KEY))
            .andExpect(jsonPath("$.redirectUrl").value(DEFAULT_REDIRECT_URL))
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
    public void getNonExistingPairContract() throws Exception {
        // Get the pairContract
        restPairContractMockMvc.perform(get("/api/pair-contracts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePairContract() throws Exception {
        // Initialize the database
        pairContractRepository.saveAndFlush(pairContract);

        int databaseSizeBeforeUpdate = pairContractRepository.findAll().size();

        // Update the pairContract
        PairContract updatedPairContract = pairContractRepository.findById(pairContract.getId()).get();
        // Disconnect from session so that the updates on updatedPairContract are not directly saved in db
        em.detach(updatedPairContract);
        updatedPairContract
            .contractName(UPDATED_CONTRACT_NAME)
            .contractCode(UPDATED_CONTRACT_CODE)
            .contractStatus(UPDATED_CONTRACT_STATUS)
            .contractDesc(UPDATED_CONTRACT_DESC)
            .dataProvIds(UPDATED_DATA_PROV_IDS)
            .dataProvNames(UPDATED_DATA_PROV_NAMES)
            .consumerName(UPDATED_CONSUMER_NAME)
            .consumerCode(UPDATED_CONSUMER_CODE)
            .appKey(UPDATED_APP_KEY)
            .startTime(UPDATED_START_TIME)
            .endTime(UPDATED_END_TIME)
            .publicKey(UPDATED_PUBLIC_KEY)
            .privateKey(UPDATED_PRIVATE_KEY)
            .redirectUrl(UPDATED_REDIRECT_URL)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        PairContractDTO pairContractDTO = pairContractMapper.toDto(updatedPairContract);

        restPairContractMockMvc.perform(put("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isOk());

        // Validate the PairContract in the database
        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeUpdate);
        PairContract testPairContract = pairContractList.get(pairContractList.size() - 1);
        assertThat(testPairContract.getContractName()).isEqualTo(UPDATED_CONTRACT_NAME);
        assertThat(testPairContract.getContractCode()).isEqualTo(UPDATED_CONTRACT_CODE);
        assertThat(testPairContract.getContractStatus()).isEqualTo(UPDATED_CONTRACT_STATUS);
        assertThat(testPairContract.getContractDesc()).isEqualTo(UPDATED_CONTRACT_DESC);
        assertThat(testPairContract.getDataProvIds()).isEqualTo(UPDATED_DATA_PROV_IDS);
        assertThat(testPairContract.getDataProvNames()).isEqualTo(UPDATED_DATA_PROV_NAMES);
        assertThat(testPairContract.getConsumerName()).isEqualTo(UPDATED_CONSUMER_NAME);
        assertThat(testPairContract.getConsumerCode()).isEqualTo(UPDATED_CONSUMER_CODE);
        assertThat(testPairContract.getAppKey()).isEqualTo(UPDATED_APP_KEY);
        assertThat(testPairContract.getStartTime()).isEqualTo(UPDATED_START_TIME);
        assertThat(testPairContract.getEndTime()).isEqualTo(UPDATED_END_TIME);
        assertThat(testPairContract.getPublicKey()).isEqualTo(UPDATED_PUBLIC_KEY);
        assertThat(testPairContract.getPrivateKey()).isEqualTo(UPDATED_PRIVATE_KEY);
        assertThat(testPairContract.getRedirectUrl()).isEqualTo(UPDATED_REDIRECT_URL);
        assertThat(testPairContract.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testPairContract.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testPairContract.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testPairContract.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testPairContract.getCreateByOrgId()).isEqualTo(UPDATED_CREATE_BY_ORG_ID);
        assertThat(testPairContract.getCreateByOrgName()).isEqualTo(UPDATED_CREATE_BY_ORG_NAME);
        assertThat(testPairContract.getLastUpTime()).isEqualTo(UPDATED_LAST_UP_TIME);
        assertThat(testPairContract.getLastUpId()).isEqualTo(UPDATED_LAST_UP_ID);
        assertThat(testPairContract.getLastUpName()).isEqualTo(UPDATED_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingPairContract() throws Exception {
        int databaseSizeBeforeUpdate = pairContractRepository.findAll().size();

        // Create the PairContract
        PairContractDTO pairContractDTO = pairContractMapper.toDto(pairContract);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPairContractMockMvc.perform(put("/api/pair-contracts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pairContractDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PairContract in the database
        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePairContract() throws Exception {
        // Initialize the database
        pairContractRepository.saveAndFlush(pairContract);

        int databaseSizeBeforeDelete = pairContractRepository.findAll().size();

        // Delete the pairContract
        restPairContractMockMvc.perform(delete("/api/pair-contracts/{id}", pairContract.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PairContract> pairContractList = pairContractRepository.findAll();
        assertThat(pairContractList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
