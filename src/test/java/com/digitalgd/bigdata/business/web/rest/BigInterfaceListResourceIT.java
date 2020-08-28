package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.BigdataBusinessApp;
import com.digitalgd.bigdata.business.domain.BigInterfaceList;
import com.digitalgd.bigdata.business.repository.BigInterfaceListRepository;
import com.digitalgd.bigdata.business.service.BigInterfaceListService;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceListDTO;
import com.digitalgd.bigdata.business.service.mapper.BigInterfaceListMapper;

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
 * Integration tests for the {@link BigInterfaceListResource} REST controller.
 */
@SpringBootTest(classes = BigdataBusinessApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class BigInterfaceListResourceIT {

    private static final String DEFAULT_INTERFACE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_INTERFACE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_INTERFACE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_INTERFACE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DATA_PROV_IDS = "AAAAAAAAAA";
    private static final String UPDATED_DATA_PROV_IDS = "BBBBBBBBBB";

    private static final String DEFAULT_DATA_PROV_NAMES = "AAAAAAAAAA";
    private static final String UPDATED_DATA_PROV_NAMES = "BBBBBBBBBB";

    private static final String DEFAULT_BIG_INTERFACE = "AAAAAAAAAA";
    private static final String UPDATED_BIG_INTERFACE = "BBBBBBBBBB";

    private static final String DEFAULT_LOCAL_PATH = "AAAAAAAAAA";
    private static final String UPDATED_LOCAL_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_PROVIDE_PATH = "AAAAAAAAAA";
    private static final String UPDATED_PROVIDE_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_INTERFACE_DESC = "AAAAAAAAAA";
    private static final String UPDATED_INTERFACE_DESC = "BBBBBBBBBB";

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
    private BigInterfaceListRepository bigInterfaceListRepository;

    @Autowired
    private BigInterfaceListMapper bigInterfaceListMapper;

    @Autowired
    private BigInterfaceListService bigInterfaceListService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBigInterfaceListMockMvc;

    private BigInterfaceList bigInterfaceList;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BigInterfaceList createEntity(EntityManager em) {
        BigInterfaceList bigInterfaceList = new BigInterfaceList()
            .interfaceCode(DEFAULT_INTERFACE_CODE)
            .interfaceName(DEFAULT_INTERFACE_NAME)
            .dataProvIds(DEFAULT_DATA_PROV_IDS)
            .dataProvNames(DEFAULT_DATA_PROV_NAMES)
            .bigInterface(DEFAULT_BIG_INTERFACE)
            .localPath(DEFAULT_LOCAL_PATH)
            .providePath(DEFAULT_PROVIDE_PATH)
            .interfaceDesc(DEFAULT_INTERFACE_DESC)
            .delFlag(DEFAULT_DEL_FLAG)
            .createTime(DEFAULT_CREATE_TIME)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createByOrgId(DEFAULT_CREATE_BY_ORG_ID)
            .createByOrgName(DEFAULT_CREATE_BY_ORG_NAME)
            .lastUpTime(DEFAULT_LAST_UP_TIME)
            .lastUpId(DEFAULT_LAST_UP_ID)
            .lastUpName(DEFAULT_LAST_UP_NAME);
        return bigInterfaceList;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BigInterfaceList createUpdatedEntity(EntityManager em) {
        BigInterfaceList bigInterfaceList = new BigInterfaceList()
            .interfaceCode(UPDATED_INTERFACE_CODE)
            .interfaceName(UPDATED_INTERFACE_NAME)
            .dataProvIds(UPDATED_DATA_PROV_IDS)
            .dataProvNames(UPDATED_DATA_PROV_NAMES)
            .bigInterface(UPDATED_BIG_INTERFACE)
            .localPath(UPDATED_LOCAL_PATH)
            .providePath(UPDATED_PROVIDE_PATH)
            .interfaceDesc(UPDATED_INTERFACE_DESC)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        return bigInterfaceList;
    }

    @BeforeEach
    public void initTest() {
        bigInterfaceList = createEntity(em);
    }

    @Test
    @Transactional
    public void createBigInterfaceList() throws Exception {
        int databaseSizeBeforeCreate = bigInterfaceListRepository.findAll().size();
        // Create the BigInterfaceList
        BigInterfaceListDTO bigInterfaceListDTO = bigInterfaceListMapper.toDto(bigInterfaceList);
        restBigInterfaceListMockMvc.perform(post("/api/big-interface-lists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceListDTO)))
            .andExpect(status().isCreated());

        // Validate the BigInterfaceList in the database
        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeCreate + 1);
        BigInterfaceList testBigInterfaceList = bigInterfaceListList.get(bigInterfaceListList.size() - 1);
        assertThat(testBigInterfaceList.getInterfaceCode()).isEqualTo(DEFAULT_INTERFACE_CODE);
        assertThat(testBigInterfaceList.getInterfaceName()).isEqualTo(DEFAULT_INTERFACE_NAME);
        assertThat(testBigInterfaceList.getDataProvIds()).isEqualTo(DEFAULT_DATA_PROV_IDS);
        assertThat(testBigInterfaceList.getDataProvNames()).isEqualTo(DEFAULT_DATA_PROV_NAMES);
        assertThat(testBigInterfaceList.getBigInterface()).isEqualTo(DEFAULT_BIG_INTERFACE);
        assertThat(testBigInterfaceList.getLocalPath()).isEqualTo(DEFAULT_LOCAL_PATH);
        assertThat(testBigInterfaceList.getProvidePath()).isEqualTo(DEFAULT_PROVIDE_PATH);
        assertThat(testBigInterfaceList.getInterfaceDesc()).isEqualTo(DEFAULT_INTERFACE_DESC);
        assertThat(testBigInterfaceList.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testBigInterfaceList.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testBigInterfaceList.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testBigInterfaceList.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testBigInterfaceList.getCreateByOrgId()).isEqualTo(DEFAULT_CREATE_BY_ORG_ID);
        assertThat(testBigInterfaceList.getCreateByOrgName()).isEqualTo(DEFAULT_CREATE_BY_ORG_NAME);
        assertThat(testBigInterfaceList.getLastUpTime()).isEqualTo(DEFAULT_LAST_UP_TIME);
        assertThat(testBigInterfaceList.getLastUpId()).isEqualTo(DEFAULT_LAST_UP_ID);
        assertThat(testBigInterfaceList.getLastUpName()).isEqualTo(DEFAULT_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void createBigInterfaceListWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bigInterfaceListRepository.findAll().size();

        // Create the BigInterfaceList with an existing ID
        bigInterfaceList.setId(1L);
        BigInterfaceListDTO bigInterfaceListDTO = bigInterfaceListMapper.toDto(bigInterfaceList);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBigInterfaceListMockMvc.perform(post("/api/big-interface-lists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceListDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BigInterfaceList in the database
        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkInterfaceCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceListRepository.findAll().size();
        // set the field null
        bigInterfaceList.setInterfaceCode(null);

        // Create the BigInterfaceList, which fails.
        BigInterfaceListDTO bigInterfaceListDTO = bigInterfaceListMapper.toDto(bigInterfaceList);


        restBigInterfaceListMockMvc.perform(post("/api/big-interface-lists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceListDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkInterfaceNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceListRepository.findAll().size();
        // set the field null
        bigInterfaceList.setInterfaceName(null);

        // Create the BigInterfaceList, which fails.
        BigInterfaceListDTO bigInterfaceListDTO = bigInterfaceListMapper.toDto(bigInterfaceList);


        restBigInterfaceListMockMvc.perform(post("/api/big-interface-lists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceListDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkBigInterfaceIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceListRepository.findAll().size();
        // set the field null
        bigInterfaceList.setBigInterface(null);

        // Create the BigInterfaceList, which fails.
        BigInterfaceListDTO bigInterfaceListDTO = bigInterfaceListMapper.toDto(bigInterfaceList);


        restBigInterfaceListMockMvc.perform(post("/api/big-interface-lists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceListDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceListRepository.findAll().size();
        // set the field null
        bigInterfaceList.setDelFlag(null);

        // Create the BigInterfaceList, which fails.
        BigInterfaceListDTO bigInterfaceListDTO = bigInterfaceListMapper.toDto(bigInterfaceList);


        restBigInterfaceListMockMvc.perform(post("/api/big-interface-lists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceListDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceListRepository.findAll().size();
        // set the field null
        bigInterfaceList.setCreateById(null);

        // Create the BigInterfaceList, which fails.
        BigInterfaceListDTO bigInterfaceListDTO = bigInterfaceListMapper.toDto(bigInterfaceList);


        restBigInterfaceListMockMvc.perform(post("/api/big-interface-lists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceListDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceListRepository.findAll().size();
        // set the field null
        bigInterfaceList.setCreateByName(null);

        // Create the BigInterfaceList, which fails.
        BigInterfaceListDTO bigInterfaceListDTO = bigInterfaceListMapper.toDto(bigInterfaceList);


        restBigInterfaceListMockMvc.perform(post("/api/big-interface-lists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceListDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCreateByOrgIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bigInterfaceListRepository.findAll().size();
        // set the field null
        bigInterfaceList.setCreateByOrgId(null);

        // Create the BigInterfaceList, which fails.
        BigInterfaceListDTO bigInterfaceListDTO = bigInterfaceListMapper.toDto(bigInterfaceList);


        restBigInterfaceListMockMvc.perform(post("/api/big-interface-lists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceListDTO)))
            .andExpect(status().isBadRequest());

        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBigInterfaceLists() throws Exception {
        // Initialize the database
        bigInterfaceListRepository.saveAndFlush(bigInterfaceList);

        // Get all the bigInterfaceListList
        restBigInterfaceListMockMvc.perform(get("/api/big-interface-lists?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bigInterfaceList.getId().intValue())))
            .andExpect(jsonPath("$.[*].interfaceCode").value(hasItem(DEFAULT_INTERFACE_CODE)))
            .andExpect(jsonPath("$.[*].interfaceName").value(hasItem(DEFAULT_INTERFACE_NAME)))
            .andExpect(jsonPath("$.[*].dataProvIds").value(hasItem(DEFAULT_DATA_PROV_IDS)))
            .andExpect(jsonPath("$.[*].dataProvNames").value(hasItem(DEFAULT_DATA_PROV_NAMES)))
            .andExpect(jsonPath("$.[*].bigInterface").value(hasItem(DEFAULT_BIG_INTERFACE)))
            .andExpect(jsonPath("$.[*].localPath").value(hasItem(DEFAULT_LOCAL_PATH)))
            .andExpect(jsonPath("$.[*].providePath").value(hasItem(DEFAULT_PROVIDE_PATH)))
            .andExpect(jsonPath("$.[*].interfaceDesc").value(hasItem(DEFAULT_INTERFACE_DESC)))
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
    public void getBigInterfaceList() throws Exception {
        // Initialize the database
        bigInterfaceListRepository.saveAndFlush(bigInterfaceList);

        // Get the bigInterfaceList
        restBigInterfaceListMockMvc.perform(get("/api/big-interface-lists/{id}", bigInterfaceList.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(bigInterfaceList.getId().intValue()))
            .andExpect(jsonPath("$.interfaceCode").value(DEFAULT_INTERFACE_CODE))
            .andExpect(jsonPath("$.interfaceName").value(DEFAULT_INTERFACE_NAME))
            .andExpect(jsonPath("$.dataProvIds").value(DEFAULT_DATA_PROV_IDS))
            .andExpect(jsonPath("$.dataProvNames").value(DEFAULT_DATA_PROV_NAMES))
            .andExpect(jsonPath("$.bigInterface").value(DEFAULT_BIG_INTERFACE))
            .andExpect(jsonPath("$.localPath").value(DEFAULT_LOCAL_PATH))
            .andExpect(jsonPath("$.providePath").value(DEFAULT_PROVIDE_PATH))
            .andExpect(jsonPath("$.interfaceDesc").value(DEFAULT_INTERFACE_DESC))
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
    public void getNonExistingBigInterfaceList() throws Exception {
        // Get the bigInterfaceList
        restBigInterfaceListMockMvc.perform(get("/api/big-interface-lists/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBigInterfaceList() throws Exception {
        // Initialize the database
        bigInterfaceListRepository.saveAndFlush(bigInterfaceList);

        int databaseSizeBeforeUpdate = bigInterfaceListRepository.findAll().size();

        // Update the bigInterfaceList
        BigInterfaceList updatedBigInterfaceList = bigInterfaceListRepository.findById(bigInterfaceList.getId()).get();
        // Disconnect from session so that the updates on updatedBigInterfaceList are not directly saved in db
        em.detach(updatedBigInterfaceList);
        updatedBigInterfaceList
            .interfaceCode(UPDATED_INTERFACE_CODE)
            .interfaceName(UPDATED_INTERFACE_NAME)
            .dataProvIds(UPDATED_DATA_PROV_IDS)
            .dataProvNames(UPDATED_DATA_PROV_NAMES)
            .bigInterface(UPDATED_BIG_INTERFACE)
            .localPath(UPDATED_LOCAL_PATH)
            .providePath(UPDATED_PROVIDE_PATH)
            .interfaceDesc(UPDATED_INTERFACE_DESC)
            .delFlag(UPDATED_DEL_FLAG)
            .createTime(UPDATED_CREATE_TIME)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createByOrgId(UPDATED_CREATE_BY_ORG_ID)
            .createByOrgName(UPDATED_CREATE_BY_ORG_NAME)
            .lastUpTime(UPDATED_LAST_UP_TIME)
            .lastUpId(UPDATED_LAST_UP_ID)
            .lastUpName(UPDATED_LAST_UP_NAME);
        BigInterfaceListDTO bigInterfaceListDTO = bigInterfaceListMapper.toDto(updatedBigInterfaceList);

        restBigInterfaceListMockMvc.perform(put("/api/big-interface-lists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceListDTO)))
            .andExpect(status().isOk());

        // Validate the BigInterfaceList in the database
        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeUpdate);
        BigInterfaceList testBigInterfaceList = bigInterfaceListList.get(bigInterfaceListList.size() - 1);
        assertThat(testBigInterfaceList.getInterfaceCode()).isEqualTo(UPDATED_INTERFACE_CODE);
        assertThat(testBigInterfaceList.getInterfaceName()).isEqualTo(UPDATED_INTERFACE_NAME);
        assertThat(testBigInterfaceList.getDataProvIds()).isEqualTo(UPDATED_DATA_PROV_IDS);
        assertThat(testBigInterfaceList.getDataProvNames()).isEqualTo(UPDATED_DATA_PROV_NAMES);
        assertThat(testBigInterfaceList.getBigInterface()).isEqualTo(UPDATED_BIG_INTERFACE);
        assertThat(testBigInterfaceList.getLocalPath()).isEqualTo(UPDATED_LOCAL_PATH);
        assertThat(testBigInterfaceList.getProvidePath()).isEqualTo(UPDATED_PROVIDE_PATH);
        assertThat(testBigInterfaceList.getInterfaceDesc()).isEqualTo(UPDATED_INTERFACE_DESC);
        assertThat(testBigInterfaceList.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testBigInterfaceList.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testBigInterfaceList.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testBigInterfaceList.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testBigInterfaceList.getCreateByOrgId()).isEqualTo(UPDATED_CREATE_BY_ORG_ID);
        assertThat(testBigInterfaceList.getCreateByOrgName()).isEqualTo(UPDATED_CREATE_BY_ORG_NAME);
        assertThat(testBigInterfaceList.getLastUpTime()).isEqualTo(UPDATED_LAST_UP_TIME);
        assertThat(testBigInterfaceList.getLastUpId()).isEqualTo(UPDATED_LAST_UP_ID);
        assertThat(testBigInterfaceList.getLastUpName()).isEqualTo(UPDATED_LAST_UP_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingBigInterfaceList() throws Exception {
        int databaseSizeBeforeUpdate = bigInterfaceListRepository.findAll().size();

        // Create the BigInterfaceList
        BigInterfaceListDTO bigInterfaceListDTO = bigInterfaceListMapper.toDto(bigInterfaceList);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBigInterfaceListMockMvc.perform(put("/api/big-interface-lists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bigInterfaceListDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BigInterfaceList in the database
        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBigInterfaceList() throws Exception {
        // Initialize the database
        bigInterfaceListRepository.saveAndFlush(bigInterfaceList);

        int databaseSizeBeforeDelete = bigInterfaceListRepository.findAll().size();

        // Delete the bigInterfaceList
        restBigInterfaceListMockMvc.perform(delete("/api/big-interface-lists/{id}", bigInterfaceList.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BigInterfaceList> bigInterfaceListList = bigInterfaceListRepository.findAll();
        assertThat(bigInterfaceListList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
