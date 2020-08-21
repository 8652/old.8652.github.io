package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.BigdataBusinessApp;
import com.digitalgd.bigdata.business.domain.AuthLetterRecord;
import com.digitalgd.bigdata.business.repository.AuthLetterRecordRepository;
import com.digitalgd.bigdata.business.service.AuthLetterRecordService;
import com.digitalgd.bigdata.business.service.dto.AuthLetterRecordDTO;
import com.digitalgd.bigdata.business.service.mapper.AuthLetterRecordMapper;

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
 * Integration tests for the {@link AuthLetterRecordResource} REST controller.
 */
@SpringBootTest(classes = BigdataBusinessApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class AuthLetterRecordResourceIT {

    private static final String DEFAULT_BIZ_ITEM_ID = "AAAAAAAAAA";
    private static final String UPDATED_BIZ_ITEM_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PAIR_CONTRACT_ID = "AAAAAAAAAA";
    private static final String UPDATED_PAIR_CONTRACT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PAIR_CONTRACT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PAIR_CONTRACT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TEMPLATE_ID = "AAAAAAAAAA";
    private static final String UPDATED_TEMPLATE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_TEMPLATE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_TEMPLATE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TEMPLATE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TEMPLATE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_FILE_PATH = "AAAAAAAAAA";
    private static final String UPDATED_FILE_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_AUTH_FILE_ID = "AAAAAAAAAA";
    private static final String UPDATED_AUTH_FILE_ID = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_AUTH_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_AUTH_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_AUTH_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_AUTH_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_PERSON_ID = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PERSON_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PERSON_ID_CARD = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_ID_CARD = "BBBBBBBBBB";

    private static final String DEFAULT_PERSON_PHONE = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_PHONE = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_SOCIAL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_SOCIAL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_AUTH_CHANNEL = "AAAAAAAAAA";
    private static final String UPDATED_AUTH_CHANNEL = "BBBBBBBBBB";

    private static final String DEFAULT_AUTH_ORIGIN = "AAAAAAAAAA";
    private static final String UPDATED_AUTH_ORIGIN = "BBBBBBBBBB";

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
    private AuthLetterRecordRepository authLetterRecordRepository;

    @Autowired
    private AuthLetterRecordMapper authLetterRecordMapper;

    @Autowired
    private AuthLetterRecordService authLetterRecordService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAuthLetterRecordMockMvc;

    private AuthLetterRecord authLetterRecord;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AuthLetterRecord createEntity(EntityManager em) {
        AuthLetterRecord authLetterRecord = new AuthLetterRecord()
            .bizItemId(DEFAULT_BIZ_ITEM_ID)
            .pairContractId(DEFAULT_PAIR_CONTRACT_ID)
            .pairContractName(DEFAULT_PAIR_CONTRACT_NAME)
            .templateId(DEFAULT_TEMPLATE_ID)
            .templateName(DEFAULT_TEMPLATE_NAME)
            .templateType(DEFAULT_TEMPLATE_TYPE)
            .filePath(DEFAULT_FILE_PATH)
            .authFileId(DEFAULT_AUTH_FILE_ID)
            .authTime(DEFAULT_AUTH_TIME)
            .authStatus(DEFAULT_AUTH_STATUS)
            .personId(DEFAULT_PERSON_ID)
            .personName(DEFAULT_PERSON_NAME)
            .personIdCard(DEFAULT_PERSON_ID_CARD)
            .personPhone(DEFAULT_PERSON_PHONE)
            .companyName(DEFAULT_COMPANY_NAME)
            .companySocialCode(DEFAULT_COMPANY_SOCIAL_CODE)
            .authChannel(DEFAULT_AUTH_CHANNEL)
            .authOrigin(DEFAULT_AUTH_ORIGIN)
            .delFlag(DEFAULT_DEL_FLAG)
            .createTime(DEFAULT_CREATE_TIME)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createByOrgId(DEFAULT_CREATE_BY_ORG_ID)
            .createByOrgName(DEFAULT_CREATE_BY_ORG_NAME)
            .lastUpTime(DEFAULT_LAST_UP_TIME)
            .lastUpId(DEFAULT_LAST_UP_ID)
            .lastUpName(DEFAULT_LAST_UP_NAME);
        return authLetterRecord;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AuthLetterRecord createUpdatedEntity(EntityManager em) {
        AuthLetterRecord authLetterRecord = new AuthLetterRecord()
            .bizItemId(UPDATED_BIZ_ITEM_ID)
            .pairContractId(UPDATED_PAIR_CONTRACT_ID)
            .pairContractName(UPDATED_PAIR_CONTRACT_NAME)
            .templateId(UPDATED_TEMPLATE_ID)
            .templateName(UPDATED_TEMPLATE_NAME)
            .templateType(UPDATED_TEMPLATE_TYPE)
            .filePath(UPDATED_FILE_PATH)
            .authFileId(UPDATED_AUTH_FILE_ID)
            .authTime(UPDATED_AUTH_TIME)
            .authStatus(UPDATED_AUTH_STATUS)
            .personId(UPDATED_PERSON_ID)
            .personName(UPDATED_PERSON_NAME)
            .personIdCard(UPDATED_PERSON_ID_CARD)
            .personPhone(UPDATED_PERSON_PHONE)
            .companyName(UPDATED_COMPANY_NAME)
            .companySocialCode(UPDATED_COMPANY_SOCIAL_CODE)
            .authChannel(UPDATED_AUTH_CHANNEL)
            .authOrigin(UPDATED_AUTH_ORIGIN)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        return authLetterRecord;
    }

    @BeforeEach
    public void initTest() {
        authLetterRecord = createEntity(em);
    }

    @Test
    @Transactional
    public void createAuthLetterRecord() throws Exception {
        int databaseSizeBeforeCreate = authLetterRecordRepository.findAll().size();
        // Create the AuthLetterRecord
        AuthLetterRecordDTO authLetterRecordDTO = authLetterRecordMapper.toDto(authLetterRecord);
        restAuthLetterRecordMockMvc.perform(post("/api/auth-letter-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterRecordDTO)))
            .andExpect(status().isCreated());

        // Validate the AuthLetterRecord in the database
        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeCreate + 1);
        AuthLetterRecord testAuthLetterRecord = authLetterRecordList.get(authLetterRecordList.size() - 1);
        assertThat(testAuthLetterRecord.getBizItemId()).isEqualTo(DEFAULT_BIZ_ITEM_ID);
        assertThat(testAuthLetterRecord.getPairContractId()).isEqualTo(DEFAULT_PAIR_CONTRACT_ID);
        assertThat(testAuthLetterRecord.getPairContractName()).isEqualTo(DEFAULT_PAIR_CONTRACT_NAME);
        assertThat(testAuthLetterRecord.getTemplateId()).isEqualTo(DEFAULT_TEMPLATE_ID);
        assertThat(testAuthLetterRecord.getTemplateName()).isEqualTo(DEFAULT_TEMPLATE_NAME);
        assertThat(testAuthLetterRecord.getTemplateType()).isEqualTo(DEFAULT_TEMPLATE_TYPE);
        assertThat(testAuthLetterRecord.getFilePath()).isEqualTo(DEFAULT_FILE_PATH);
        assertThat(testAuthLetterRecord.getAuthFileId()).isEqualTo(DEFAULT_AUTH_FILE_ID);
        assertThat(testAuthLetterRecord.getAuthTime()).isEqualTo(DEFAULT_AUTH_TIME);
        assertThat(testAuthLetterRecord.getAuthStatus()).isEqualTo(DEFAULT_AUTH_STATUS);
        assertThat(testAuthLetterRecord.getPersonId()).isEqualTo(DEFAULT_PERSON_ID);
        assertThat(testAuthLetterRecord.getPersonName()).isEqualTo(DEFAULT_PERSON_NAME);
        assertThat(testAuthLetterRecord.getPersonIdCard()).isEqualTo(DEFAULT_PERSON_ID_CARD);
        assertThat(testAuthLetterRecord.getPersonPhone()).isEqualTo(DEFAULT_PERSON_PHONE);
        assertThat(testAuthLetterRecord.getCompanyName()).isEqualTo(DEFAULT_COMPANY_NAME);
        assertThat(testAuthLetterRecord.getCompanySocialCode()).isEqualTo(DEFAULT_COMPANY_SOCIAL_CODE);
        assertThat(testAuthLetterRecord.getAuthChannel()).isEqualTo(DEFAULT_AUTH_CHANNEL);
        assertThat(testAuthLetterRecord.getAuthOrigin()).isEqualTo(DEFAULT_AUTH_ORIGIN);
        assertThat(testAuthLetterRecord.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testAuthLetterRecord.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testAuthLetterRecord.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testAuthLetterRecord.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testAuthLetterRecord.getCreateByOrgId()).isEqualTo(DEFAULT_CREATE_BY_ORG_ID);
        assertThat(testAuthLetterRecord.getCreateByOrgName()).isEqualTo(DEFAULT_CREATE_BY_ORG_NAME);
        assertThat(testAuthLetterRecord.getLastUpTime()).isEqualTo(DEFAULT_LAST_UP_TIME);
        assertThat(testAuthLetterRecord.getLastUpId()).isEqualTo(DEFAULT_LAST_UP_ID);
        assertThat(testAuthLetterRecord.getLastUpName()).isEqualTo(DEFAULT_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void createAuthLetterRecordWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = authLetterRecordRepository.findAll().size();

        // Create the AuthLetterRecord with an existing ID
        authLetterRecord.setId(1L);
        AuthLetterRecordDTO authLetterRecordDTO = authLetterRecordMapper.toDto(authLetterRecord);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAuthLetterRecordMockMvc.perform(post("/api/auth-letter-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterRecordDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AuthLetterRecord in the database
        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkBizItemIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterRecordRepository.findAll().size();
        // set the field null
        authLetterRecord.setBizItemId(null);

        // Create the AuthLetterRecord, which fails.
        AuthLetterRecordDTO authLetterRecordDTO = authLetterRecordMapper.toDto(authLetterRecord);


        restAuthLetterRecordMockMvc.perform(post("/api/auth-letter-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterRecordDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPairContractIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterRecordRepository.findAll().size();
        // set the field null
        authLetterRecord.setPairContractId(null);

        // Create the AuthLetterRecord, which fails.
        AuthLetterRecordDTO authLetterRecordDTO = authLetterRecordMapper.toDto(authLetterRecord);


        restAuthLetterRecordMockMvc.perform(post("/api/auth-letter-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterRecordDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPairContractNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterRecordRepository.findAll().size();
        // set the field null
        authLetterRecord.setPairContractName(null);

        // Create the AuthLetterRecord, which fails.
        AuthLetterRecordDTO authLetterRecordDTO = authLetterRecordMapper.toDto(authLetterRecord);


        restAuthLetterRecordMockMvc.perform(post("/api/auth-letter-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterRecordDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterRecordRepository.findAll().size();
        // set the field null
        authLetterRecord.setDelFlag(null);

        // Create the AuthLetterRecord, which fails.
        AuthLetterRecordDTO authLetterRecordDTO = authLetterRecordMapper.toDto(authLetterRecord);


        restAuthLetterRecordMockMvc.perform(post("/api/auth-letter-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterRecordDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterRecordRepository.findAll().size();
        // set the field null
        authLetterRecord.setCreateById(null);

        // Create the AuthLetterRecord, which fails.
        AuthLetterRecordDTO authLetterRecordDTO = authLetterRecordMapper.toDto(authLetterRecord);


        restAuthLetterRecordMockMvc.perform(post("/api/auth-letter-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterRecordDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterRecordRepository.findAll().size();
        // set the field null
        authLetterRecord.setCreateByName(null);

        // Create the AuthLetterRecord, which fails.
        AuthLetterRecordDTO authLetterRecordDTO = authLetterRecordMapper.toDto(authLetterRecord);


        restAuthLetterRecordMockMvc.perform(post("/api/auth-letter-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterRecordDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByOrgIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterRecordRepository.findAll().size();
        // set the field null
        authLetterRecord.setCreateByOrgId(null);

        // Create the AuthLetterRecord, which fails.
        AuthLetterRecordDTO authLetterRecordDTO = authLetterRecordMapper.toDto(authLetterRecord);


        restAuthLetterRecordMockMvc.perform(post("/api/auth-letter-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterRecordDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllAuthLetterRecords() throws Exception {
        // Initialize the database
        authLetterRecordRepository.saveAndFlush(authLetterRecord);

        // Get all the authLetterRecordList
        restAuthLetterRecordMockMvc.perform(get("/api/auth-letter-records?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(authLetterRecord.getId().intValue())))
            .andExpect(jsonPath("$.[*].bizItemId").value(hasItem(DEFAULT_BIZ_ITEM_ID)))
            .andExpect(jsonPath("$.[*].pairContractId").value(hasItem(DEFAULT_PAIR_CONTRACT_ID)))
            .andExpect(jsonPath("$.[*].pairContractName").value(hasItem(DEFAULT_PAIR_CONTRACT_NAME)))
            .andExpect(jsonPath("$.[*].templateId").value(hasItem(DEFAULT_TEMPLATE_ID)))
            .andExpect(jsonPath("$.[*].templateName").value(hasItem(DEFAULT_TEMPLATE_NAME)))
            .andExpect(jsonPath("$.[*].templateType").value(hasItem(DEFAULT_TEMPLATE_TYPE)))
            .andExpect(jsonPath("$.[*].filePath").value(hasItem(DEFAULT_FILE_PATH)))
            .andExpect(jsonPath("$.[*].authFileId").value(hasItem(DEFAULT_AUTH_FILE_ID)))
            .andExpect(jsonPath("$.[*].authTime").value(hasItem(sameInstant(DEFAULT_AUTH_TIME))))
            .andExpect(jsonPath("$.[*].authStatus").value(hasItem(DEFAULT_AUTH_STATUS)))
            .andExpect(jsonPath("$.[*].personId").value(hasItem(DEFAULT_PERSON_ID)))
            .andExpect(jsonPath("$.[*].personName").value(hasItem(DEFAULT_PERSON_NAME)))
            .andExpect(jsonPath("$.[*].personIdCard").value(hasItem(DEFAULT_PERSON_ID_CARD)))
            .andExpect(jsonPath("$.[*].personPhone").value(hasItem(DEFAULT_PERSON_PHONE)))
            .andExpect(jsonPath("$.[*].companyName").value(hasItem(DEFAULT_COMPANY_NAME)))
            .andExpect(jsonPath("$.[*].companySocialCode").value(hasItem(DEFAULT_COMPANY_SOCIAL_CODE)))
            .andExpect(jsonPath("$.[*].authChannel").value(hasItem(DEFAULT_AUTH_CHANNEL)))
            .andExpect(jsonPath("$.[*].authOrigin").value(hasItem(DEFAULT_AUTH_ORIGIN)))
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
    public void getAuthLetterRecord() throws Exception {
        // Initialize the database
        authLetterRecordRepository.saveAndFlush(authLetterRecord);

        // Get the authLetterRecord
        restAuthLetterRecordMockMvc.perform(get("/api/auth-letter-records/{id}", authLetterRecord.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(authLetterRecord.getId().intValue()))
            .andExpect(jsonPath("$.bizItemId").value(DEFAULT_BIZ_ITEM_ID))
            .andExpect(jsonPath("$.pairContractId").value(DEFAULT_PAIR_CONTRACT_ID))
            .andExpect(jsonPath("$.pairContractName").value(DEFAULT_PAIR_CONTRACT_NAME))
            .andExpect(jsonPath("$.templateId").value(DEFAULT_TEMPLATE_ID))
            .andExpect(jsonPath("$.templateName").value(DEFAULT_TEMPLATE_NAME))
            .andExpect(jsonPath("$.templateType").value(DEFAULT_TEMPLATE_TYPE))
            .andExpect(jsonPath("$.filePath").value(DEFAULT_FILE_PATH))
            .andExpect(jsonPath("$.authFileId").value(DEFAULT_AUTH_FILE_ID))
            .andExpect(jsonPath("$.authTime").value(sameInstant(DEFAULT_AUTH_TIME)))
            .andExpect(jsonPath("$.authStatus").value(DEFAULT_AUTH_STATUS))
            .andExpect(jsonPath("$.personId").value(DEFAULT_PERSON_ID))
            .andExpect(jsonPath("$.personName").value(DEFAULT_PERSON_NAME))
            .andExpect(jsonPath("$.personIdCard").value(DEFAULT_PERSON_ID_CARD))
            .andExpect(jsonPath("$.personPhone").value(DEFAULT_PERSON_PHONE))
            .andExpect(jsonPath("$.companyName").value(DEFAULT_COMPANY_NAME))
            .andExpect(jsonPath("$.companySocialCode").value(DEFAULT_COMPANY_SOCIAL_CODE))
            .andExpect(jsonPath("$.authChannel").value(DEFAULT_AUTH_CHANNEL))
            .andExpect(jsonPath("$.authOrigin").value(DEFAULT_AUTH_ORIGIN))
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
    public void getNonExistingAuthLetterRecord() throws Exception {
        // Get the authLetterRecord
        restAuthLetterRecordMockMvc.perform(get("/api/auth-letter-records/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAuthLetterRecord() throws Exception {
        // Initialize the database
        authLetterRecordRepository.saveAndFlush(authLetterRecord);

        int databaseSizeBeforeUpdate = authLetterRecordRepository.findAll().size();

        // Update the authLetterRecord
        AuthLetterRecord updatedAuthLetterRecord = authLetterRecordRepository.findById(authLetterRecord.getId()).get();
        // Disconnect from session so that the updates on updatedAuthLetterRecord are not directly saved in db
        em.detach(updatedAuthLetterRecord);
        updatedAuthLetterRecord
            .bizItemId(UPDATED_BIZ_ITEM_ID)
            .pairContractId(UPDATED_PAIR_CONTRACT_ID)
            .pairContractName(UPDATED_PAIR_CONTRACT_NAME)
            .templateId(UPDATED_TEMPLATE_ID)
            .templateName(UPDATED_TEMPLATE_NAME)
            .templateType(UPDATED_TEMPLATE_TYPE)
            .filePath(UPDATED_FILE_PATH)
            .authFileId(UPDATED_AUTH_FILE_ID)
            .authTime(UPDATED_AUTH_TIME)
            .authStatus(UPDATED_AUTH_STATUS)
            .personId(UPDATED_PERSON_ID)
            .personName(UPDATED_PERSON_NAME)
            .personIdCard(UPDATED_PERSON_ID_CARD)
            .personPhone(UPDATED_PERSON_PHONE)
            .companyName(UPDATED_COMPANY_NAME)
            .companySocialCode(UPDATED_COMPANY_SOCIAL_CODE)
            .authChannel(UPDATED_AUTH_CHANNEL)
            .authOrigin(UPDATED_AUTH_ORIGIN)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        AuthLetterRecordDTO authLetterRecordDTO = authLetterRecordMapper.toDto(updatedAuthLetterRecord);

        restAuthLetterRecordMockMvc.perform(put("/api/auth-letter-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterRecordDTO)))
            .andExpect(status().isOk());

        // Validate the AuthLetterRecord in the database
        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeUpdate);
        AuthLetterRecord testAuthLetterRecord = authLetterRecordList.get(authLetterRecordList.size() - 1);
        assertThat(testAuthLetterRecord.getBizItemId()).isEqualTo(UPDATED_BIZ_ITEM_ID);
        assertThat(testAuthLetterRecord.getPairContractId()).isEqualTo(UPDATED_PAIR_CONTRACT_ID);
        assertThat(testAuthLetterRecord.getPairContractName()).isEqualTo(UPDATED_PAIR_CONTRACT_NAME);
        assertThat(testAuthLetterRecord.getTemplateId()).isEqualTo(UPDATED_TEMPLATE_ID);
        assertThat(testAuthLetterRecord.getTemplateName()).isEqualTo(UPDATED_TEMPLATE_NAME);
        assertThat(testAuthLetterRecord.getTemplateType()).isEqualTo(UPDATED_TEMPLATE_TYPE);
        assertThat(testAuthLetterRecord.getFilePath()).isEqualTo(UPDATED_FILE_PATH);
        assertThat(testAuthLetterRecord.getAuthFileId()).isEqualTo(UPDATED_AUTH_FILE_ID);
        assertThat(testAuthLetterRecord.getAuthTime()).isEqualTo(UPDATED_AUTH_TIME);
        assertThat(testAuthLetterRecord.getAuthStatus()).isEqualTo(UPDATED_AUTH_STATUS);
        assertThat(testAuthLetterRecord.getPersonId()).isEqualTo(UPDATED_PERSON_ID);
        assertThat(testAuthLetterRecord.getPersonName()).isEqualTo(UPDATED_PERSON_NAME);
        assertThat(testAuthLetterRecord.getPersonIdCard()).isEqualTo(UPDATED_PERSON_ID_CARD);
        assertThat(testAuthLetterRecord.getPersonPhone()).isEqualTo(UPDATED_PERSON_PHONE);
        assertThat(testAuthLetterRecord.getCompanyName()).isEqualTo(UPDATED_COMPANY_NAME);
        assertThat(testAuthLetterRecord.getCompanySocialCode()).isEqualTo(UPDATED_COMPANY_SOCIAL_CODE);
        assertThat(testAuthLetterRecord.getAuthChannel()).isEqualTo(UPDATED_AUTH_CHANNEL);
        assertThat(testAuthLetterRecord.getAuthOrigin()).isEqualTo(UPDATED_AUTH_ORIGIN);
        assertThat(testAuthLetterRecord.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testAuthLetterRecord.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testAuthLetterRecord.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testAuthLetterRecord.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testAuthLetterRecord.getCreateByOrgId()).isEqualTo(UPDATED_CREATE_BY_ORG_ID);
        assertThat(testAuthLetterRecord.getCreateByOrgName()).isEqualTo(UPDATED_CREATE_BY_ORG_NAME);
        assertThat(testAuthLetterRecord.getLastUpTime()).isEqualTo(UPDATED_LAST_UP_TIME);
        assertThat(testAuthLetterRecord.getLastUpId()).isEqualTo(UPDATED_LAST_UP_ID);
        assertThat(testAuthLetterRecord.getLastUpName()).isEqualTo(UPDATED_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingAuthLetterRecord() throws Exception {
        int databaseSizeBeforeUpdate = authLetterRecordRepository.findAll().size();

        // Create the AuthLetterRecord
        AuthLetterRecordDTO authLetterRecordDTO = authLetterRecordMapper.toDto(authLetterRecord);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAuthLetterRecordMockMvc.perform(put("/api/auth-letter-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterRecordDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AuthLetterRecord in the database
        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAuthLetterRecord() throws Exception {
        // Initialize the database
        authLetterRecordRepository.saveAndFlush(authLetterRecord);

        int databaseSizeBeforeDelete = authLetterRecordRepository.findAll().size();

        // Delete the authLetterRecord
        restAuthLetterRecordMockMvc.perform(delete("/api/auth-letter-records/{id}", authLetterRecord.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AuthLetterRecord> authLetterRecordList = authLetterRecordRepository.findAll();
        assertThat(authLetterRecordList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
