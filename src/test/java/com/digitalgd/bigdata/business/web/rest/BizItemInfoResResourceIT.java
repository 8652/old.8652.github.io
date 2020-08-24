package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.BigdataBusinessApp;
import com.digitalgd.bigdata.business.domain.BizItemInfoRes;
import com.digitalgd.bigdata.business.repository.BizItemInfoResRepository;
import com.digitalgd.bigdata.business.service.BizItemInfoResService;
import com.digitalgd.bigdata.business.service.dto.BizItemInfoResDTO;
import com.digitalgd.bigdata.business.service.mapper.BizItemInfoResMapper;

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
 * Integration tests for the {@link BizItemInfoResResource} REST controller.
 */
@SpringBootTest(classes = BigdataBusinessApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class BizItemInfoResResourceIT {

    private static final String DEFAULT_PKID = "AAAAAAAAAA";
    private static final String UPDATED_PKID = "BBBBBBBBBB";

    private static final String DEFAULT_BIZ_ITEM_ID = "AAAAAAAAAA";
    private static final String UPDATED_BIZ_ITEM_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ORIGIN_DEP = "AAAAAAAAAA";
    private static final String UPDATED_ORIGIN_DEP = "BBBBBBBBBB";

    private static final String DEFAULT_CATEGORY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CATEGORY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CATEGORY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CATEGORY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_TERM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_TERM_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TERM_CODE = "AAAAAAAAAA";
    private static final String UPDATED_TERM_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SHARE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_SHARE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_OPEN_ATTR = "AAAAAAAAAA";
    private static final String UPDATED_OPEN_ATTR = "BBBBBBBBBB";

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
    private BizItemInfoResRepository bizItemInfoResRepository;

    @Autowired
    private BizItemInfoResMapper bizItemInfoResMapper;

    @Autowired
    private BizItemInfoResService bizItemInfoResService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBizItemInfoResMockMvc;

    private BizItemInfoRes bizItemInfoRes;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BizItemInfoRes createEntity(EntityManager em) {
        BizItemInfoRes bizItemInfoRes = new BizItemInfoRes()
            .pkid(DEFAULT_PKID)
            .bizItemId(DEFAULT_BIZ_ITEM_ID)
            .originDep(DEFAULT_ORIGIN_DEP)
            .categoryName(DEFAULT_CATEGORY_NAME)
            .categoryCode(DEFAULT_CATEGORY_CODE)
            .termName(DEFAULT_TERM_NAME)
            .termCode(DEFAULT_TERM_CODE)
            .shareType(DEFAULT_SHARE_TYPE)
            .openAttr(DEFAULT_OPEN_ATTR)
            .delFlag(DEFAULT_DEL_FLAG)
            .createTime(DEFAULT_CREATE_TIME)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createByOrgId(DEFAULT_CREATE_BY_ORG_ID)
            .createByOrgName(DEFAULT_CREATE_BY_ORG_NAME)
            .lastUpTime(DEFAULT_LAST_UP_TIME)
            .lastUpId(DEFAULT_LAST_UP_ID)
            .lastUpName(DEFAULT_LAST_UP_NAME);
        return bizItemInfoRes;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BizItemInfoRes createUpdatedEntity(EntityManager em) {
        BizItemInfoRes bizItemInfoRes = new BizItemInfoRes()
            .pkid(UPDATED_PKID)
            .bizItemId(UPDATED_BIZ_ITEM_ID)
            .originDep(UPDATED_ORIGIN_DEP)
            .categoryName(UPDATED_CATEGORY_NAME)
            .categoryCode(UPDATED_CATEGORY_CODE)
            .termName(UPDATED_TERM_NAME)
            .termCode(UPDATED_TERM_CODE)
            .shareType(UPDATED_SHARE_TYPE)
            .openAttr(UPDATED_OPEN_ATTR)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        return bizItemInfoRes;
    }

    @BeforeEach
    public void initTest() {
        bizItemInfoRes = createEntity(em);
    }

    @Test
    @Transactional
    public void createBizItemInfoRes() throws Exception {
        int databaseSizeBeforeCreate = bizItemInfoResRepository.findAll().size();
        // Create the BizItemInfoRes
        BizItemInfoResDTO bizItemInfoResDTO = bizItemInfoResMapper.toDto(bizItemInfoRes);
        restBizItemInfoResMockMvc.perform(post("/api/biz-item-info-res")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemInfoResDTO)))
            .andExpect(status().isCreated());

        // Validate the BizItemInfoRes in the database
        List<BizItemInfoRes> bizItemInfoResList = bizItemInfoResRepository.findAll();
        assertThat(bizItemInfoResList).hasSize(databaseSizeBeforeCreate + 1);
        BizItemInfoRes testBizItemInfoRes = bizItemInfoResList.get(bizItemInfoResList.size() - 1);
        assertThat(testBizItemInfoRes.getPkid()).isEqualTo(DEFAULT_PKID);
        assertThat(testBizItemInfoRes.getBizItemId()).isEqualTo(DEFAULT_BIZ_ITEM_ID);
        assertThat(testBizItemInfoRes.getOriginDep()).isEqualTo(DEFAULT_ORIGIN_DEP);
        assertThat(testBizItemInfoRes.getCategoryName()).isEqualTo(DEFAULT_CATEGORY_NAME);
        assertThat(testBizItemInfoRes.getCategoryCode()).isEqualTo(DEFAULT_CATEGORY_CODE);
        assertThat(testBizItemInfoRes.getTermName()).isEqualTo(DEFAULT_TERM_NAME);
        assertThat(testBizItemInfoRes.getTermCode()).isEqualTo(DEFAULT_TERM_CODE);
        assertThat(testBizItemInfoRes.getShareType()).isEqualTo(DEFAULT_SHARE_TYPE);
        assertThat(testBizItemInfoRes.getOpenAttr()).isEqualTo(DEFAULT_OPEN_ATTR);
        assertThat(testBizItemInfoRes.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testBizItemInfoRes.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testBizItemInfoRes.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testBizItemInfoRes.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testBizItemInfoRes.getCreateByOrgId()).isEqualTo(DEFAULT_CREATE_BY_ORG_ID);
        assertThat(testBizItemInfoRes.getCreateByOrgName()).isEqualTo(DEFAULT_CREATE_BY_ORG_NAME);
        assertThat(testBizItemInfoRes.getLastUpTime()).isEqualTo(DEFAULT_LAST_UP_TIME);
        assertThat(testBizItemInfoRes.getLastUpId()).isEqualTo(DEFAULT_LAST_UP_ID);
        assertThat(testBizItemInfoRes.getLastUpName()).isEqualTo(DEFAULT_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void createBizItemInfoResWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bizItemInfoResRepository.findAll().size();

        // Create the BizItemInfoRes with an existing ID
        bizItemInfoRes.setId(1L);
        BizItemInfoResDTO bizItemInfoResDTO = bizItemInfoResMapper.toDto(bizItemInfoRes);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBizItemInfoResMockMvc.perform(post("/api/biz-item-info-res")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemInfoResDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BizItemInfoRes in the database
        List<BizItemInfoRes> bizItemInfoResList = bizItemInfoResRepository.findAll();
        assertThat(bizItemInfoResList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkBizItemIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemInfoResRepository.findAll().size();
        // set the field null
        bizItemInfoRes.setBizItemId(null);

        // Create the BizItemInfoRes, which fails.
        BizItemInfoResDTO bizItemInfoResDTO = bizItemInfoResMapper.toDto(bizItemInfoRes);


        restBizItemInfoResMockMvc.perform(post("/api/biz-item-info-res")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemInfoResDTO)))
            .andExpect(status().isBadRequest());

        List<BizItemInfoRes> bizItemInfoResList = bizItemInfoResRepository.findAll();
        assertThat(bizItemInfoResList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemInfoResRepository.findAll().size();
        // set the field null
        bizItemInfoRes.setDelFlag(null);

        // Create the BizItemInfoRes, which fails.
        BizItemInfoResDTO bizItemInfoResDTO = bizItemInfoResMapper.toDto(bizItemInfoRes);


        restBizItemInfoResMockMvc.perform(post("/api/biz-item-info-res")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemInfoResDTO)))
            .andExpect(status().isBadRequest());

        List<BizItemInfoRes> bizItemInfoResList = bizItemInfoResRepository.findAll();
        assertThat(bizItemInfoResList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemInfoResRepository.findAll().size();
        // set the field null
        bizItemInfoRes.setCreateById(null);

        // Create the BizItemInfoRes, which fails.
        BizItemInfoResDTO bizItemInfoResDTO = bizItemInfoResMapper.toDto(bizItemInfoRes);


        restBizItemInfoResMockMvc.perform(post("/api/biz-item-info-res")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemInfoResDTO)))
            .andExpect(status().isBadRequest());

        List<BizItemInfoRes> bizItemInfoResList = bizItemInfoResRepository.findAll();
        assertThat(bizItemInfoResList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemInfoResRepository.findAll().size();
        // set the field null
        bizItemInfoRes.setCreateByName(null);

        // Create the BizItemInfoRes, which fails.
        BizItemInfoResDTO bizItemInfoResDTO = bizItemInfoResMapper.toDto(bizItemInfoRes);


        restBizItemInfoResMockMvc.perform(post("/api/biz-item-info-res")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemInfoResDTO)))
            .andExpect(status().isBadRequest());

        List<BizItemInfoRes> bizItemInfoResList = bizItemInfoResRepository.findAll();
        assertThat(bizItemInfoResList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByOrgIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemInfoResRepository.findAll().size();
        // set the field null
        bizItemInfoRes.setCreateByOrgId(null);

        // Create the BizItemInfoRes, which fails.
        BizItemInfoResDTO bizItemInfoResDTO = bizItemInfoResMapper.toDto(bizItemInfoRes);


        restBizItemInfoResMockMvc.perform(post("/api/biz-item-info-res")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemInfoResDTO)))
            .andExpect(status().isBadRequest());

        List<BizItemInfoRes> bizItemInfoResList = bizItemInfoResRepository.findAll();
        assertThat(bizItemInfoResList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBizItemInfoRes() throws Exception {
        // Initialize the database
        bizItemInfoResRepository.saveAndFlush(bizItemInfoRes);

        // Get all the bizItemInfoResList
        restBizItemInfoResMockMvc.perform(get("/api/biz-item-info-res?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bizItemInfoRes.getId().intValue())))
            .andExpect(jsonPath("$.[*].pkid").value(hasItem(DEFAULT_PKID)))
            .andExpect(jsonPath("$.[*].bizItemId").value(hasItem(DEFAULT_BIZ_ITEM_ID)))
            .andExpect(jsonPath("$.[*].originDep").value(hasItem(DEFAULT_ORIGIN_DEP)))
            .andExpect(jsonPath("$.[*].categoryName").value(hasItem(DEFAULT_CATEGORY_NAME)))
            .andExpect(jsonPath("$.[*].categoryCode").value(hasItem(DEFAULT_CATEGORY_CODE)))
            .andExpect(jsonPath("$.[*].termName").value(hasItem(DEFAULT_TERM_NAME)))
            .andExpect(jsonPath("$.[*].termCode").value(hasItem(DEFAULT_TERM_CODE)))
            .andExpect(jsonPath("$.[*].shareType").value(hasItem(DEFAULT_SHARE_TYPE)))
            .andExpect(jsonPath("$.[*].openAttr").value(hasItem(DEFAULT_OPEN_ATTR)))
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
    public void getBizItemInfoRes() throws Exception {
        // Initialize the database
        bizItemInfoResRepository.saveAndFlush(bizItemInfoRes);

        // Get the bizItemInfoRes
        restBizItemInfoResMockMvc.perform(get("/api/biz-item-info-res/{id}", bizItemInfoRes.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(bizItemInfoRes.getId().intValue()))
            .andExpect(jsonPath("$.pkid").value(DEFAULT_PKID))
            .andExpect(jsonPath("$.bizItemId").value(DEFAULT_BIZ_ITEM_ID))
            .andExpect(jsonPath("$.originDep").value(DEFAULT_ORIGIN_DEP))
            .andExpect(jsonPath("$.categoryName").value(DEFAULT_CATEGORY_NAME))
            .andExpect(jsonPath("$.categoryCode").value(DEFAULT_CATEGORY_CODE))
            .andExpect(jsonPath("$.termName").value(DEFAULT_TERM_NAME))
            .andExpect(jsonPath("$.termCode").value(DEFAULT_TERM_CODE))
            .andExpect(jsonPath("$.shareType").value(DEFAULT_SHARE_TYPE))
            .andExpect(jsonPath("$.openAttr").value(DEFAULT_OPEN_ATTR))
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
    public void getNonExistingBizItemInfoRes() throws Exception {
        // Get the bizItemInfoRes
        restBizItemInfoResMockMvc.perform(get("/api/biz-item-info-res/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBizItemInfoRes() throws Exception {
        // Initialize the database
        bizItemInfoResRepository.saveAndFlush(bizItemInfoRes);

        int databaseSizeBeforeUpdate = bizItemInfoResRepository.findAll().size();

        // Update the bizItemInfoRes
        BizItemInfoRes updatedBizItemInfoRes = bizItemInfoResRepository.findById(bizItemInfoRes.getId()).get();
        // Disconnect from session so that the updates on updatedBizItemInfoRes are not directly saved in db
        em.detach(updatedBizItemInfoRes);
        updatedBizItemInfoRes
            .pkid(UPDATED_PKID)
            .bizItemId(UPDATED_BIZ_ITEM_ID)
            .originDep(UPDATED_ORIGIN_DEP)
            .categoryName(UPDATED_CATEGORY_NAME)
            .categoryCode(UPDATED_CATEGORY_CODE)
            .termName(UPDATED_TERM_NAME)
            .termCode(UPDATED_TERM_CODE)
            .shareType(UPDATED_SHARE_TYPE)
            .openAttr(UPDATED_OPEN_ATTR)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        BizItemInfoResDTO bizItemInfoResDTO = bizItemInfoResMapper.toDto(updatedBizItemInfoRes);

        restBizItemInfoResMockMvc.perform(put("/api/biz-item-info-res")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemInfoResDTO)))
            .andExpect(status().isOk());

        // Validate the BizItemInfoRes in the database
        List<BizItemInfoRes> bizItemInfoResList = bizItemInfoResRepository.findAll();
        assertThat(bizItemInfoResList).hasSize(databaseSizeBeforeUpdate);
        BizItemInfoRes testBizItemInfoRes = bizItemInfoResList.get(bizItemInfoResList.size() - 1);
        assertThat(testBizItemInfoRes.getPkid()).isEqualTo(UPDATED_PKID);
        assertThat(testBizItemInfoRes.getBizItemId()).isEqualTo(UPDATED_BIZ_ITEM_ID);
        assertThat(testBizItemInfoRes.getOriginDep()).isEqualTo(UPDATED_ORIGIN_DEP);
        assertThat(testBizItemInfoRes.getCategoryName()).isEqualTo(UPDATED_CATEGORY_NAME);
        assertThat(testBizItemInfoRes.getCategoryCode()).isEqualTo(UPDATED_CATEGORY_CODE);
        assertThat(testBizItemInfoRes.getTermName()).isEqualTo(UPDATED_TERM_NAME);
        assertThat(testBizItemInfoRes.getTermCode()).isEqualTo(UPDATED_TERM_CODE);
        assertThat(testBizItemInfoRes.getShareType()).isEqualTo(UPDATED_SHARE_TYPE);
        assertThat(testBizItemInfoRes.getOpenAttr()).isEqualTo(UPDATED_OPEN_ATTR);
        assertThat(testBizItemInfoRes.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testBizItemInfoRes.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testBizItemInfoRes.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testBizItemInfoRes.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testBizItemInfoRes.getCreateByOrgId()).isEqualTo(UPDATED_CREATE_BY_ORG_ID);
        assertThat(testBizItemInfoRes.getCreateByOrgName()).isEqualTo(UPDATED_CREATE_BY_ORG_NAME);
        assertThat(testBizItemInfoRes.getLastUpTime()).isEqualTo(UPDATED_LAST_UP_TIME);
        assertThat(testBizItemInfoRes.getLastUpId()).isEqualTo(UPDATED_LAST_UP_ID);
        assertThat(testBizItemInfoRes.getLastUpName()).isEqualTo(UPDATED_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingBizItemInfoRes() throws Exception {
        int databaseSizeBeforeUpdate = bizItemInfoResRepository.findAll().size();

        // Create the BizItemInfoRes
        BizItemInfoResDTO bizItemInfoResDTO = bizItemInfoResMapper.toDto(bizItemInfoRes);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBizItemInfoResMockMvc.perform(put("/api/biz-item-info-res")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemInfoResDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BizItemInfoRes in the database
        List<BizItemInfoRes> bizItemInfoResList = bizItemInfoResRepository.findAll();
        assertThat(bizItemInfoResList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBizItemInfoRes() throws Exception {
        // Initialize the database
        bizItemInfoResRepository.saveAndFlush(bizItemInfoRes);

        int databaseSizeBeforeDelete = bizItemInfoResRepository.findAll().size();

        // Delete the bizItemInfoRes
        restBizItemInfoResMockMvc.perform(delete("/api/biz-item-info-res/{id}", bizItemInfoRes.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BizItemInfoRes> bizItemInfoResList = bizItemInfoResRepository.findAll();
        assertThat(bizItemInfoResList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
