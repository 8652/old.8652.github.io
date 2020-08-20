package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.BigdataBusinessApp;
import com.digitalgd.bigdata.business.domain.BizItem;
import com.digitalgd.bigdata.business.repository.BizItemRepository;
import com.digitalgd.bigdata.business.service.BizItemService;
import com.digitalgd.bigdata.business.service.dto.BizItemDTO;
import com.digitalgd.bigdata.business.service.mapper.BizItemMapper;

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
 * Integration tests for the {@link BizItemResource} REST controller.
 */
@SpringBootTest(classes = BigdataBusinessApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class BizItemResourceIT {

    private static final String DEFAULT_ITEM_CODE = "AAAAAAAA";
    private static final String UPDATED_ITEM_CODE = "BBBBBBBB";

    private static final String DEFAULT_ITEM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ITEM_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DATA_PROV_IDS = "AAAAAAAAAA";
    private static final String UPDATED_DATA_PROV_IDS = "BBBBBBBBBB";

    private static final String DEFAULT_DATA_PROV_NAMES = "AAAAAAAAAA";
    private static final String UPDATED_DATA_PROV_NAMES = "BBBBBBBBBB";

    private static final String DEFAULT_CONSUMER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CONSUMER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CONSUMER_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CONSUMER_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PAIR_CONTACT_ID = "AAAAAAAAAA";
    private static final String UPDATED_PAIR_CONTACT_ID = "BBBBBBBBBB";

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
    private BizItemRepository bizItemRepository;

    @Autowired
    private BizItemMapper bizItemMapper;

    @Autowired
    private BizItemService bizItemService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBizItemMockMvc;

    private BizItem bizItem;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BizItem createEntity(EntityManager em) {
        BizItem bizItem = new BizItem()
            .itemCode(DEFAULT_ITEM_CODE)
            .itemName(DEFAULT_ITEM_NAME)
            .dataProvIds(DEFAULT_DATA_PROV_IDS)
            .dataProvNames(DEFAULT_DATA_PROV_NAMES)
            .consumerName(DEFAULT_CONSUMER_NAME)
            .consumerCode(DEFAULT_CONSUMER_CODE)
            .pairContactId(DEFAULT_PAIR_CONTACT_ID)
            .delFlag(DEFAULT_DEL_FLAG)
            .createTime(DEFAULT_CREATE_TIME)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createByOrgId(DEFAULT_CREATE_BY_ORG_ID)
            .createByOrgName(DEFAULT_CREATE_BY_ORG_NAME)
            .lastUpTime(DEFAULT_LAST_UP_TIME)
            .lastUpId(DEFAULT_LAST_UP_ID)
            .lastUpName(DEFAULT_LAST_UP_NAME);
        return bizItem;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BizItem createUpdatedEntity(EntityManager em) {
        BizItem bizItem = new BizItem()
            .itemCode(UPDATED_ITEM_CODE)
            .itemName(UPDATED_ITEM_NAME)
            .dataProvIds(UPDATED_DATA_PROV_IDS)
            .dataProvNames(UPDATED_DATA_PROV_NAMES)
            .consumerName(UPDATED_CONSUMER_NAME)
            .consumerCode(UPDATED_CONSUMER_CODE)
            .pairContactId(UPDATED_PAIR_CONTACT_ID)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        return bizItem;
    }

    @BeforeEach
    public void initTest() {
        bizItem = createEntity(em);
    }

    @Test
    @Transactional
    public void createBizItem() throws Exception {
        int databaseSizeBeforeCreate = bizItemRepository.findAll().size();
        // Create the BizItem
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);
        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isCreated());

        // Validate the BizItem in the database
        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeCreate + 1);
        BizItem testBizItem = bizItemList.get(bizItemList.size() - 1);
        assertThat(testBizItem.getItemCode()).isEqualTo(DEFAULT_ITEM_CODE);
        assertThat(testBizItem.getItemName()).isEqualTo(DEFAULT_ITEM_NAME);
        assertThat(testBizItem.getDataProvIds()).isEqualTo(DEFAULT_DATA_PROV_IDS);
        assertThat(testBizItem.getDataProvNames()).isEqualTo(DEFAULT_DATA_PROV_NAMES);
        assertThat(testBizItem.getConsumerName()).isEqualTo(DEFAULT_CONSUMER_NAME);
        assertThat(testBizItem.getConsumerCode()).isEqualTo(DEFAULT_CONSUMER_CODE);
        assertThat(testBizItem.getPairContactId()).isEqualTo(DEFAULT_PAIR_CONTACT_ID);
        assertThat(testBizItem.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testBizItem.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testBizItem.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testBizItem.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testBizItem.getCreateByOrgId()).isEqualTo(DEFAULT_CREATE_BY_ORG_ID);
        assertThat(testBizItem.getCreateByOrgName()).isEqualTo(DEFAULT_CREATE_BY_ORG_NAME);
        assertThat(testBizItem.getLastUpTime()).isEqualTo(DEFAULT_LAST_UP_TIME);
        assertThat(testBizItem.getLastUpId()).isEqualTo(DEFAULT_LAST_UP_ID);
        assertThat(testBizItem.getLastUpName()).isEqualTo(DEFAULT_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void createBizItemWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bizItemRepository.findAll().size();

        // Create the BizItem with an existing ID
        bizItem.setId(1L);
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BizItem in the database
        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkItemCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemRepository.findAll().size();
        // set the field null
        bizItem.setItemCode(null);

        // Create the BizItem, which fails.
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);


        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkItemNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemRepository.findAll().size();
        // set the field null
        bizItem.setItemName(null);

        // Create the BizItem, which fails.
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);


        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDataProvIdsIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemRepository.findAll().size();
        // set the field null
        bizItem.setDataProvIds(null);

        // Create the BizItem, which fails.
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);


        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDataProvNamesIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemRepository.findAll().size();
        // set the field null
        bizItem.setDataProvNames(null);

        // Create the BizItem, which fails.
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);


        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkConsumerNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemRepository.findAll().size();
        // set the field null
        bizItem.setConsumerName(null);

        // Create the BizItem, which fails.
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);


        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkConsumerCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemRepository.findAll().size();
        // set the field null
        bizItem.setConsumerCode(null);

        // Create the BizItem, which fails.
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);


        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPairContactIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemRepository.findAll().size();
        // set the field null
        bizItem.setPairContactId(null);

        // Create the BizItem, which fails.
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);


        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemRepository.findAll().size();
        // set the field null
        bizItem.setDelFlag(null);

        // Create the BizItem, which fails.
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);


        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemRepository.findAll().size();
        // set the field null
        bizItem.setCreateById(null);

        // Create the BizItem, which fails.
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);


        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemRepository.findAll().size();
        // set the field null
        bizItem.setCreateByName(null);

        // Create the BizItem, which fails.
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);


        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByOrgIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bizItemRepository.findAll().size();
        // set the field null
        bizItem.setCreateByOrgId(null);

        // Create the BizItem, which fails.
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);


        restBizItemMockMvc.perform(post("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBizItems() throws Exception {
        // Initialize the database
        bizItemRepository.saveAndFlush(bizItem);

        // Get all the bizItemList
        restBizItemMockMvc.perform(get("/api/biz-items?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bizItem.getId().intValue())))
            .andExpect(jsonPath("$.[*].itemCode").value(hasItem(DEFAULT_ITEM_CODE)))
            .andExpect(jsonPath("$.[*].itemName").value(hasItem(DEFAULT_ITEM_NAME)))
            .andExpect(jsonPath("$.[*].dataProvIds").value(hasItem(DEFAULT_DATA_PROV_IDS)))
            .andExpect(jsonPath("$.[*].dataProvNames").value(hasItem(DEFAULT_DATA_PROV_NAMES)))
            .andExpect(jsonPath("$.[*].consumerName").value(hasItem(DEFAULT_CONSUMER_NAME)))
            .andExpect(jsonPath("$.[*].consumerCode").value(hasItem(DEFAULT_CONSUMER_CODE)))
            .andExpect(jsonPath("$.[*].pairContactId").value(hasItem(DEFAULT_PAIR_CONTACT_ID)))
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
    public void getBizItem() throws Exception {
        // Initialize the database
        bizItemRepository.saveAndFlush(bizItem);

        // Get the bizItem
        restBizItemMockMvc.perform(get("/api/biz-items/{id}", bizItem.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(bizItem.getId().intValue()))
            .andExpect(jsonPath("$.itemCode").value(DEFAULT_ITEM_CODE))
            .andExpect(jsonPath("$.itemName").value(DEFAULT_ITEM_NAME))
            .andExpect(jsonPath("$.dataProvIds").value(DEFAULT_DATA_PROV_IDS))
            .andExpect(jsonPath("$.dataProvNames").value(DEFAULT_DATA_PROV_NAMES))
            .andExpect(jsonPath("$.consumerName").value(DEFAULT_CONSUMER_NAME))
            .andExpect(jsonPath("$.consumerCode").value(DEFAULT_CONSUMER_CODE))
            .andExpect(jsonPath("$.pairContactId").value(DEFAULT_PAIR_CONTACT_ID))
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
    public void getNonExistingBizItem() throws Exception {
        // Get the bizItem
        restBizItemMockMvc.perform(get("/api/biz-items/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBizItem() throws Exception {
        // Initialize the database
        bizItemRepository.saveAndFlush(bizItem);

        int databaseSizeBeforeUpdate = bizItemRepository.findAll().size();

        // Update the bizItem
        BizItem updatedBizItem = bizItemRepository.findById(bizItem.getId()).get();
        // Disconnect from session so that the updates on updatedBizItem are not directly saved in db
        em.detach(updatedBizItem);
        updatedBizItem
            .itemCode(UPDATED_ITEM_CODE)
            .itemName(UPDATED_ITEM_NAME)
            .dataProvIds(UPDATED_DATA_PROV_IDS)
            .dataProvNames(UPDATED_DATA_PROV_NAMES)
            .consumerName(UPDATED_CONSUMER_NAME)
            .consumerCode(UPDATED_CONSUMER_CODE)
            .pairContactId(UPDATED_PAIR_CONTACT_ID)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        BizItemDTO bizItemDTO = bizItemMapper.toDto(updatedBizItem);

        restBizItemMockMvc.perform(put("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isOk());

        // Validate the BizItem in the database
        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeUpdate);
        BizItem testBizItem = bizItemList.get(bizItemList.size() - 1);
        assertThat(testBizItem.getItemCode()).isEqualTo(UPDATED_ITEM_CODE);
        assertThat(testBizItem.getItemName()).isEqualTo(UPDATED_ITEM_NAME);
        assertThat(testBizItem.getDataProvIds()).isEqualTo(UPDATED_DATA_PROV_IDS);
        assertThat(testBizItem.getDataProvNames()).isEqualTo(UPDATED_DATA_PROV_NAMES);
        assertThat(testBizItem.getConsumerName()).isEqualTo(UPDATED_CONSUMER_NAME);
        assertThat(testBizItem.getConsumerCode()).isEqualTo(UPDATED_CONSUMER_CODE);
        assertThat(testBizItem.getPairContactId()).isEqualTo(UPDATED_PAIR_CONTACT_ID);
        assertThat(testBizItem.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testBizItem.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testBizItem.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testBizItem.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testBizItem.getCreateByOrgId()).isEqualTo(UPDATED_CREATE_BY_ORG_ID);
        assertThat(testBizItem.getCreateByOrgName()).isEqualTo(UPDATED_CREATE_BY_ORG_NAME);
        assertThat(testBizItem.getLastUpTime()).isEqualTo(UPDATED_LAST_UP_TIME);
        assertThat(testBizItem.getLastUpId()).isEqualTo(UPDATED_LAST_UP_ID);
        assertThat(testBizItem.getLastUpName()).isEqualTo(UPDATED_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingBizItem() throws Exception {
        int databaseSizeBeforeUpdate = bizItemRepository.findAll().size();

        // Create the BizItem
        BizItemDTO bizItemDTO = bizItemMapper.toDto(bizItem);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBizItemMockMvc.perform(put("/api/biz-items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bizItemDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BizItem in the database
        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBizItem() throws Exception {
        // Initialize the database
        bizItemRepository.saveAndFlush(bizItem);

        int databaseSizeBeforeDelete = bizItemRepository.findAll().size();

        // Delete the bizItem
        restBizItemMockMvc.perform(delete("/api/biz-items/{id}", bizItem.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BizItem> bizItemList = bizItemRepository.findAll();
        assertThat(bizItemList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
