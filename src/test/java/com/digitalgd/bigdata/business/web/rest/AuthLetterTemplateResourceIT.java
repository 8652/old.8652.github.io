package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.BigdataBusinessApp;
import com.digitalgd.bigdata.business.domain.AuthLetterTemplate;
import com.digitalgd.bigdata.business.repository.AuthLetterTemplateRepository;
import com.digitalgd.bigdata.business.service.AuthLetterTemplateService;
import com.digitalgd.bigdata.business.service.dto.AuthLetterTemplateDTO;
import com.digitalgd.bigdata.business.service.mapper.AuthLetterTemplateMapper;

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
 * Integration tests for the {@link AuthLetterTemplateResource} REST controller.
 */
@SpringBootTest(classes = BigdataBusinessApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class AuthLetterTemplateResourceIT {

    private static final String DEFAULT_PKID = "AAAAAAAAAA";
    private static final String UPDATED_PKID = "BBBBBBBBBB";

    private static final String DEFAULT_BIZ_ITEM_ID = "AAAAAAAAAA";
    private static final String UPDATED_BIZ_ITEM_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PAIR_CONTRACT_ID = "AAAAAAAAAA";
    private static final String UPDATED_PAIR_CONTRACT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PAIR_CONTRACT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PAIR_CONTRACT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TEMPLATE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_TEMPLATE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TEMPLATE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TEMPLATE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_FILE_PATH = "AAAAAAAAAA";
    private static final String UPDATED_FILE_PATH = "BBBBBBBBBB";

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
    private AuthLetterTemplateRepository authLetterTemplateRepository;

    @Autowired
    private AuthLetterTemplateMapper authLetterTemplateMapper;

    @Autowired
    private AuthLetterTemplateService authLetterTemplateService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAuthLetterTemplateMockMvc;

    private AuthLetterTemplate authLetterTemplate;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AuthLetterTemplate createEntity(EntityManager em) {
        AuthLetterTemplate authLetterTemplate = new AuthLetterTemplate()
            .pkid(DEFAULT_PKID)
            .bizItemId(DEFAULT_BIZ_ITEM_ID)
            .pairContractId(DEFAULT_PAIR_CONTRACT_ID)
            .pairContractName(DEFAULT_PAIR_CONTRACT_NAME)
            .templateName(DEFAULT_TEMPLATE_NAME)
            .templateType(DEFAULT_TEMPLATE_TYPE)
            .filePath(DEFAULT_FILE_PATH)
            .delFlag(DEFAULT_DEL_FLAG)
            .createTime(DEFAULT_CREATE_TIME)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createByOrgId(DEFAULT_CREATE_BY_ORG_ID)
            .createByOrgName(DEFAULT_CREATE_BY_ORG_NAME)
            .lastUpTime(DEFAULT_LAST_UP_TIME)
            .lastUpId(DEFAULT_LAST_UP_ID)
            .lastUpName(DEFAULT_LAST_UP_NAME);
        return authLetterTemplate;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AuthLetterTemplate createUpdatedEntity(EntityManager em) {
        AuthLetterTemplate authLetterTemplate = new AuthLetterTemplate()
            .pkid(UPDATED_PKID)
            .bizItemId(UPDATED_BIZ_ITEM_ID)
            .pairContractId(UPDATED_PAIR_CONTRACT_ID)
            .pairContractName(UPDATED_PAIR_CONTRACT_NAME)
            .templateName(UPDATED_TEMPLATE_NAME)
            .templateType(UPDATED_TEMPLATE_TYPE)
            .filePath(UPDATED_FILE_PATH)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        return authLetterTemplate;
    }

    @BeforeEach
    public void initTest() {
        authLetterTemplate = createEntity(em);
    }

    @Test
    @Transactional
    public void createAuthLetterTemplate() throws Exception {
        int databaseSizeBeforeCreate = authLetterTemplateRepository.findAll().size();
        // Create the AuthLetterTemplate
        AuthLetterTemplateDTO authLetterTemplateDTO = authLetterTemplateMapper.toDto(authLetterTemplate);
        restAuthLetterTemplateMockMvc.perform(post("/api/auth-letter-templates")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterTemplateDTO)))
            .andExpect(status().isCreated());

        // Validate the AuthLetterTemplate in the database
        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeCreate + 1);
        AuthLetterTemplate testAuthLetterTemplate = authLetterTemplateList.get(authLetterTemplateList.size() - 1);
        assertThat(testAuthLetterTemplate.getPkid()).isEqualTo(DEFAULT_PKID);
        assertThat(testAuthLetterTemplate.getBizItemId()).isEqualTo(DEFAULT_BIZ_ITEM_ID);
        assertThat(testAuthLetterTemplate.getPairContractId()).isEqualTo(DEFAULT_PAIR_CONTRACT_ID);
        assertThat(testAuthLetterTemplate.getPairContractName()).isEqualTo(DEFAULT_PAIR_CONTRACT_NAME);
        assertThat(testAuthLetterTemplate.getTemplateName()).isEqualTo(DEFAULT_TEMPLATE_NAME);
        assertThat(testAuthLetterTemplate.getTemplateType()).isEqualTo(DEFAULT_TEMPLATE_TYPE);
        assertThat(testAuthLetterTemplate.getFilePath()).isEqualTo(DEFAULT_FILE_PATH);
        assertThat(testAuthLetterTemplate.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testAuthLetterTemplate.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testAuthLetterTemplate.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testAuthLetterTemplate.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testAuthLetterTemplate.getCreateByOrgId()).isEqualTo(DEFAULT_CREATE_BY_ORG_ID);
        assertThat(testAuthLetterTemplate.getCreateByOrgName()).isEqualTo(DEFAULT_CREATE_BY_ORG_NAME);
        assertThat(testAuthLetterTemplate.getLastUpTime()).isEqualTo(DEFAULT_LAST_UP_TIME);
        assertThat(testAuthLetterTemplate.getLastUpId()).isEqualTo(DEFAULT_LAST_UP_ID);
        assertThat(testAuthLetterTemplate.getLastUpName()).isEqualTo(DEFAULT_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void createAuthLetterTemplateWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = authLetterTemplateRepository.findAll().size();

        // Create the AuthLetterTemplate with an existing ID
        authLetterTemplate.setId(1L);
        AuthLetterTemplateDTO authLetterTemplateDTO = authLetterTemplateMapper.toDto(authLetterTemplate);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAuthLetterTemplateMockMvc.perform(post("/api/auth-letter-templates")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterTemplateDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AuthLetterTemplate in the database
        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkBizItemIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterTemplateRepository.findAll().size();
        // set the field null
        authLetterTemplate.setBizItemId(null);

        // Create the AuthLetterTemplate, which fails.
        AuthLetterTemplateDTO authLetterTemplateDTO = authLetterTemplateMapper.toDto(authLetterTemplate);


        restAuthLetterTemplateMockMvc.perform(post("/api/auth-letter-templates")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterTemplateDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPairContractIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterTemplateRepository.findAll().size();
        // set the field null
        authLetterTemplate.setPairContractId(null);

        // Create the AuthLetterTemplate, which fails.
        AuthLetterTemplateDTO authLetterTemplateDTO = authLetterTemplateMapper.toDto(authLetterTemplate);


        restAuthLetterTemplateMockMvc.perform(post("/api/auth-letter-templates")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterTemplateDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPairContractNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterTemplateRepository.findAll().size();
        // set the field null
        authLetterTemplate.setPairContractName(null);

        // Create the AuthLetterTemplate, which fails.
        AuthLetterTemplateDTO authLetterTemplateDTO = authLetterTemplateMapper.toDto(authLetterTemplate);


        restAuthLetterTemplateMockMvc.perform(post("/api/auth-letter-templates")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterTemplateDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterTemplateRepository.findAll().size();
        // set the field null
        authLetterTemplate.setDelFlag(null);

        // Create the AuthLetterTemplate, which fails.
        AuthLetterTemplateDTO authLetterTemplateDTO = authLetterTemplateMapper.toDto(authLetterTemplate);


        restAuthLetterTemplateMockMvc.perform(post("/api/auth-letter-templates")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterTemplateDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterTemplateRepository.findAll().size();
        // set the field null
        authLetterTemplate.setCreateById(null);

        // Create the AuthLetterTemplate, which fails.
        AuthLetterTemplateDTO authLetterTemplateDTO = authLetterTemplateMapper.toDto(authLetterTemplate);


        restAuthLetterTemplateMockMvc.perform(post("/api/auth-letter-templates")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterTemplateDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterTemplateRepository.findAll().size();
        // set the field null
        authLetterTemplate.setCreateByName(null);

        // Create the AuthLetterTemplate, which fails.
        AuthLetterTemplateDTO authLetterTemplateDTO = authLetterTemplateMapper.toDto(authLetterTemplate);


        restAuthLetterTemplateMockMvc.perform(post("/api/auth-letter-templates")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterTemplateDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByOrgIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = authLetterTemplateRepository.findAll().size();
        // set the field null
        authLetterTemplate.setCreateByOrgId(null);

        // Create the AuthLetterTemplate, which fails.
        AuthLetterTemplateDTO authLetterTemplateDTO = authLetterTemplateMapper.toDto(authLetterTemplate);


        restAuthLetterTemplateMockMvc.perform(post("/api/auth-letter-templates")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterTemplateDTO)))
            .andExpect(status().isBadRequest());

        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllAuthLetterTemplates() throws Exception {
        // Initialize the database
        authLetterTemplateRepository.saveAndFlush(authLetterTemplate);

        // Get all the authLetterTemplateList
        restAuthLetterTemplateMockMvc.perform(get("/api/auth-letter-templates?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(authLetterTemplate.getId().intValue())))
            .andExpect(jsonPath("$.[*].pkid").value(hasItem(DEFAULT_PKID)))
            .andExpect(jsonPath("$.[*].bizItemId").value(hasItem(DEFAULT_BIZ_ITEM_ID)))
            .andExpect(jsonPath("$.[*].pairContractId").value(hasItem(DEFAULT_PAIR_CONTRACT_ID)))
            .andExpect(jsonPath("$.[*].pairContractName").value(hasItem(DEFAULT_PAIR_CONTRACT_NAME)))
            .andExpect(jsonPath("$.[*].templateName").value(hasItem(DEFAULT_TEMPLATE_NAME)))
            .andExpect(jsonPath("$.[*].templateType").value(hasItem(DEFAULT_TEMPLATE_TYPE)))
            .andExpect(jsonPath("$.[*].filePath").value(hasItem(DEFAULT_FILE_PATH)))
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
    public void getAuthLetterTemplate() throws Exception {
        // Initialize the database
        authLetterTemplateRepository.saveAndFlush(authLetterTemplate);

        // Get the authLetterTemplate
        restAuthLetterTemplateMockMvc.perform(get("/api/auth-letter-templates/{id}", authLetterTemplate.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(authLetterTemplate.getId().intValue()))
            .andExpect(jsonPath("$.pkid").value(DEFAULT_PKID))
            .andExpect(jsonPath("$.bizItemId").value(DEFAULT_BIZ_ITEM_ID))
            .andExpect(jsonPath("$.pairContractId").value(DEFAULT_PAIR_CONTRACT_ID))
            .andExpect(jsonPath("$.pairContractName").value(DEFAULT_PAIR_CONTRACT_NAME))
            .andExpect(jsonPath("$.templateName").value(DEFAULT_TEMPLATE_NAME))
            .andExpect(jsonPath("$.templateType").value(DEFAULT_TEMPLATE_TYPE))
            .andExpect(jsonPath("$.filePath").value(DEFAULT_FILE_PATH))
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
    public void getNonExistingAuthLetterTemplate() throws Exception {
        // Get the authLetterTemplate
        restAuthLetterTemplateMockMvc.perform(get("/api/auth-letter-templates/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAuthLetterTemplate() throws Exception {
        // Initialize the database
        authLetterTemplateRepository.saveAndFlush(authLetterTemplate);

        int databaseSizeBeforeUpdate = authLetterTemplateRepository.findAll().size();

        // Update the authLetterTemplate
        AuthLetterTemplate updatedAuthLetterTemplate = authLetterTemplateRepository.findById(authLetterTemplate.getId()).get();
        // Disconnect from session so that the updates on updatedAuthLetterTemplate are not directly saved in db
        em.detach(updatedAuthLetterTemplate);
        updatedAuthLetterTemplate
            .pkid(UPDATED_PKID)
            .bizItemId(UPDATED_BIZ_ITEM_ID)
            .pairContractId(UPDATED_PAIR_CONTRACT_ID)
            .pairContractName(UPDATED_PAIR_CONTRACT_NAME)
            .templateName(UPDATED_TEMPLATE_NAME)
            .templateType(UPDATED_TEMPLATE_TYPE)
            .filePath(UPDATED_FILE_PATH)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        AuthLetterTemplateDTO authLetterTemplateDTO = authLetterTemplateMapper.toDto(updatedAuthLetterTemplate);

        restAuthLetterTemplateMockMvc.perform(put("/api/auth-letter-templates")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterTemplateDTO)))
            .andExpect(status().isOk());

        // Validate the AuthLetterTemplate in the database
        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeUpdate);
        AuthLetterTemplate testAuthLetterTemplate = authLetterTemplateList.get(authLetterTemplateList.size() - 1);
        assertThat(testAuthLetterTemplate.getPkid()).isEqualTo(UPDATED_PKID);
        assertThat(testAuthLetterTemplate.getBizItemId()).isEqualTo(UPDATED_BIZ_ITEM_ID);
        assertThat(testAuthLetterTemplate.getPairContractId()).isEqualTo(UPDATED_PAIR_CONTRACT_ID);
        assertThat(testAuthLetterTemplate.getPairContractName()).isEqualTo(UPDATED_PAIR_CONTRACT_NAME);
        assertThat(testAuthLetterTemplate.getTemplateName()).isEqualTo(UPDATED_TEMPLATE_NAME);
        assertThat(testAuthLetterTemplate.getTemplateType()).isEqualTo(UPDATED_TEMPLATE_TYPE);
        assertThat(testAuthLetterTemplate.getFilePath()).isEqualTo(UPDATED_FILE_PATH);
        assertThat(testAuthLetterTemplate.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testAuthLetterTemplate.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testAuthLetterTemplate.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testAuthLetterTemplate.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testAuthLetterTemplate.getCreateByOrgId()).isEqualTo(UPDATED_CREATE_BY_ORG_ID);
        assertThat(testAuthLetterTemplate.getCreateByOrgName()).isEqualTo(UPDATED_CREATE_BY_ORG_NAME);
        assertThat(testAuthLetterTemplate.getLastUpTime()).isEqualTo(UPDATED_LAST_UP_TIME);
        assertThat(testAuthLetterTemplate.getLastUpId()).isEqualTo(UPDATED_LAST_UP_ID);
        assertThat(testAuthLetterTemplate.getLastUpName()).isEqualTo(UPDATED_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingAuthLetterTemplate() throws Exception {
        int databaseSizeBeforeUpdate = authLetterTemplateRepository.findAll().size();

        // Create the AuthLetterTemplate
        AuthLetterTemplateDTO authLetterTemplateDTO = authLetterTemplateMapper.toDto(authLetterTemplate);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAuthLetterTemplateMockMvc.perform(put("/api/auth-letter-templates")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(authLetterTemplateDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AuthLetterTemplate in the database
        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAuthLetterTemplate() throws Exception {
        // Initialize the database
        authLetterTemplateRepository.saveAndFlush(authLetterTemplate);

        int databaseSizeBeforeDelete = authLetterTemplateRepository.findAll().size();

        // Delete the authLetterTemplate
        restAuthLetterTemplateMockMvc.perform(delete("/api/auth-letter-templates/{id}", authLetterTemplate.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AuthLetterTemplate> authLetterTemplateList = authLetterTemplateRepository.findAll();
        assertThat(authLetterTemplateList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
