package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.BigdataBusinessApp;
import com.digitalgd.bigdata.business.domain.SystemLog;
import com.digitalgd.bigdata.business.repository.SystemLogRepository;
import com.digitalgd.bigdata.business.service.SystemLogService;
import com.digitalgd.bigdata.business.service.dto.SystemLogDTO;
import com.digitalgd.bigdata.business.service.mapper.SystemLogMapper;

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
 * Integration tests for the {@link SystemLogResource} REST controller.
 */
@SpringBootTest(classes = BigdataBusinessApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SystemLogResourceIT {

    private static final String DEFAULT_OPERATOR_NAME = "AAAAAAAAAA";
    private static final String UPDATED_OPERATOR_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_OPERATOR_ID = "AAAAAAAAAA";
    private static final String UPDATED_OPERATOR_ID = "BBBBBBBBBB";

    private static final String DEFAULT_OPERATOR_DEPT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_OPERATOR_DEPT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_OPERATOR_DEPT_ID = "AAAAAAAAAA";
    private static final String UPDATED_OPERATOR_DEPT_ID = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_OPERATE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_OPERATE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_OPERATE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_OPERATE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENT = "AAAAAAAAAA";
    private static final String UPDATED_CONTENT = "BBBBBBBBBB";

    private static final String DEFAULT_MEMO = "AAAAAAAAAA";
    private static final String UPDATED_MEMO = "BBBBBBBBBB";

    private static final String DEFAULT_OPREATE_PARAMS = "AAAAAAAAAA";
    private static final String UPDATED_OPREATE_PARAMS = "BBBBBBBBBB";

    private static final String DEFAULT_GLOBAL_UNIQUE_ID = "AAAAAAAAAA";
    private static final String UPDATED_GLOBAL_UNIQUE_ID = "BBBBBBBBBB";

    private static final Boolean DEFAULT_DEL_FLAG = false;
    private static final Boolean UPDATED_DEL_FLAG = true;

    @Autowired
    private SystemLogRepository systemLogRepository;

    @Autowired
    private SystemLogMapper systemLogMapper;

    @Autowired
    private SystemLogService systemLogService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSystemLogMockMvc;

    private SystemLog systemLog;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SystemLog createEntity(EntityManager em) {
        SystemLog systemLog = new SystemLog()
            .operatorName(DEFAULT_OPERATOR_NAME)
            .operatorId(DEFAULT_OPERATOR_ID)
            .operatorDeptName(DEFAULT_OPERATOR_DEPT_NAME)
            .operatorDeptId(DEFAULT_OPERATOR_DEPT_ID)
            .operateTime(DEFAULT_OPERATE_TIME)
            .operateType(DEFAULT_OPERATE_TYPE)
            .content(DEFAULT_CONTENT)
            .memo(DEFAULT_MEMO)
            .opreateParams(DEFAULT_OPREATE_PARAMS)
            .globalUniqueId(DEFAULT_GLOBAL_UNIQUE_ID)
            .delFlag(DEFAULT_DEL_FLAG);
        return systemLog;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SystemLog createUpdatedEntity(EntityManager em) {
        SystemLog systemLog = new SystemLog()
            .operatorName(UPDATED_OPERATOR_NAME)
            .operatorId(UPDATED_OPERATOR_ID)
            .operatorDeptName(UPDATED_OPERATOR_DEPT_NAME)
            .operatorDeptId(UPDATED_OPERATOR_DEPT_ID)
            .operateTime(UPDATED_OPERATE_TIME)
            .operateType(UPDATED_OPERATE_TYPE)
            .content(UPDATED_CONTENT)
            .memo(UPDATED_MEMO)
            .opreateParams(UPDATED_OPREATE_PARAMS)
            .globalUniqueId(UPDATED_GLOBAL_UNIQUE_ID)
            .delFlag(UPDATED_DEL_FLAG);
        return systemLog;
    }

    @BeforeEach
    public void initTest() {
        systemLog = createEntity(em);
    }

    @Test
    @Transactional
    public void createSystemLog() throws Exception {
        int databaseSizeBeforeCreate = systemLogRepository.findAll().size();
        // Create the SystemLog
        SystemLogDTO systemLogDTO = systemLogMapper.toDto(systemLog);
        restSystemLogMockMvc.perform(post("/api/system-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(systemLogDTO)))
            .andExpect(status().isCreated());

        // Validate the SystemLog in the database
        List<SystemLog> systemLogList = systemLogRepository.findAll();
        assertThat(systemLogList).hasSize(databaseSizeBeforeCreate + 1);
        SystemLog testSystemLog = systemLogList.get(systemLogList.size() - 1);
        assertThat(testSystemLog.getOperatorName()).isEqualTo(DEFAULT_OPERATOR_NAME);
        assertThat(testSystemLog.getOperatorId()).isEqualTo(DEFAULT_OPERATOR_ID);
        assertThat(testSystemLog.getOperatorDeptName()).isEqualTo(DEFAULT_OPERATOR_DEPT_NAME);
        assertThat(testSystemLog.getOperatorDeptId()).isEqualTo(DEFAULT_OPERATOR_DEPT_ID);
        assertThat(testSystemLog.getOperateTime()).isEqualTo(DEFAULT_OPERATE_TIME);
        assertThat(testSystemLog.getOperateType()).isEqualTo(DEFAULT_OPERATE_TYPE);
        assertThat(testSystemLog.getContent()).isEqualTo(DEFAULT_CONTENT);
        assertThat(testSystemLog.getMemo()).isEqualTo(DEFAULT_MEMO);
        assertThat(testSystemLog.getOpreateParams()).isEqualTo(DEFAULT_OPREATE_PARAMS);
        assertThat(testSystemLog.getGlobalUniqueId()).isEqualTo(DEFAULT_GLOBAL_UNIQUE_ID);
        assertThat(testSystemLog.isDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
    }

    @Test
    @Transactional
    public void createSystemLogWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = systemLogRepository.findAll().size();

        // Create the SystemLog with an existing ID
        systemLog.setId(1L);
        SystemLogDTO systemLogDTO = systemLogMapper.toDto(systemLog);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSystemLogMockMvc.perform(post("/api/system-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(systemLogDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SystemLog in the database
        List<SystemLog> systemLogList = systemLogRepository.findAll();
        assertThat(systemLogList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkOperatorNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = systemLogRepository.findAll().size();
        // set the field null
        systemLog.setOperatorName(null);

        // Create the SystemLog, which fails.
        SystemLogDTO systemLogDTO = systemLogMapper.toDto(systemLog);


        restSystemLogMockMvc.perform(post("/api/system-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(systemLogDTO)))
            .andExpect(status().isBadRequest());

        List<SystemLog> systemLogList = systemLogRepository.findAll();
        assertThat(systemLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkOperatorIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = systemLogRepository.findAll().size();
        // set the field null
        systemLog.setOperatorId(null);

        // Create the SystemLog, which fails.
        SystemLogDTO systemLogDTO = systemLogMapper.toDto(systemLog);


        restSystemLogMockMvc.perform(post("/api/system-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(systemLogDTO)))
            .andExpect(status().isBadRequest());

        List<SystemLog> systemLogList = systemLogRepository.findAll();
        assertThat(systemLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = systemLogRepository.findAll().size();
        // set the field null
        systemLog.setDelFlag(null);

        // Create the SystemLog, which fails.
        SystemLogDTO systemLogDTO = systemLogMapper.toDto(systemLog);


        restSystemLogMockMvc.perform(post("/api/system-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(systemLogDTO)))
            .andExpect(status().isBadRequest());

        List<SystemLog> systemLogList = systemLogRepository.findAll();
        assertThat(systemLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSystemLogs() throws Exception {
        // Initialize the database
        systemLogRepository.saveAndFlush(systemLog);

        // Get all the systemLogList
        restSystemLogMockMvc.perform(get("/api/system-logs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(systemLog.getId().intValue())))
            .andExpect(jsonPath("$.[*].operatorName").value(hasItem(DEFAULT_OPERATOR_NAME)))
            .andExpect(jsonPath("$.[*].operatorId").value(hasItem(DEFAULT_OPERATOR_ID)))
            .andExpect(jsonPath("$.[*].operatorDeptName").value(hasItem(DEFAULT_OPERATOR_DEPT_NAME)))
            .andExpect(jsonPath("$.[*].operatorDeptId").value(hasItem(DEFAULT_OPERATOR_DEPT_ID)))
            .andExpect(jsonPath("$.[*].operateTime").value(hasItem(sameInstant(DEFAULT_OPERATE_TIME))))
            .andExpect(jsonPath("$.[*].operateType").value(hasItem(DEFAULT_OPERATE_TYPE)))
            .andExpect(jsonPath("$.[*].content").value(hasItem(DEFAULT_CONTENT)))
            .andExpect(jsonPath("$.[*].memo").value(hasItem(DEFAULT_MEMO)))
            .andExpect(jsonPath("$.[*].opreateParams").value(hasItem(DEFAULT_OPREATE_PARAMS)))
            .andExpect(jsonPath("$.[*].globalUniqueId").value(hasItem(DEFAULT_GLOBAL_UNIQUE_ID)))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getSystemLog() throws Exception {
        // Initialize the database
        systemLogRepository.saveAndFlush(systemLog);

        // Get the systemLog
        restSystemLogMockMvc.perform(get("/api/system-logs/{id}", systemLog.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(systemLog.getId().intValue()))
            .andExpect(jsonPath("$.operatorName").value(DEFAULT_OPERATOR_NAME))
            .andExpect(jsonPath("$.operatorId").value(DEFAULT_OPERATOR_ID))
            .andExpect(jsonPath("$.operatorDeptName").value(DEFAULT_OPERATOR_DEPT_NAME))
            .andExpect(jsonPath("$.operatorDeptId").value(DEFAULT_OPERATOR_DEPT_ID))
            .andExpect(jsonPath("$.operateTime").value(sameInstant(DEFAULT_OPERATE_TIME)))
            .andExpect(jsonPath("$.operateType").value(DEFAULT_OPERATE_TYPE))
            .andExpect(jsonPath("$.content").value(DEFAULT_CONTENT))
            .andExpect(jsonPath("$.memo").value(DEFAULT_MEMO))
            .andExpect(jsonPath("$.opreateParams").value(DEFAULT_OPREATE_PARAMS))
            .andExpect(jsonPath("$.globalUniqueId").value(DEFAULT_GLOBAL_UNIQUE_ID))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG.booleanValue()));
    }
    @Test
    @Transactional
    public void getNonExistingSystemLog() throws Exception {
        // Get the systemLog
        restSystemLogMockMvc.perform(get("/api/system-logs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSystemLog() throws Exception {
        // Initialize the database
        systemLogRepository.saveAndFlush(systemLog);

        int databaseSizeBeforeUpdate = systemLogRepository.findAll().size();

        // Update the systemLog
        SystemLog updatedSystemLog = systemLogRepository.findById(systemLog.getId()).get();
        // Disconnect from session so that the updates on updatedSystemLog are not directly saved in db
        em.detach(updatedSystemLog);
        updatedSystemLog
            .operatorName(UPDATED_OPERATOR_NAME)
            .operatorId(UPDATED_OPERATOR_ID)
            .operatorDeptName(UPDATED_OPERATOR_DEPT_NAME)
            .operatorDeptId(UPDATED_OPERATOR_DEPT_ID)
            .operateTime(UPDATED_OPERATE_TIME)
            .operateType(UPDATED_OPERATE_TYPE)
            .content(UPDATED_CONTENT)
            .memo(UPDATED_MEMO)
            .opreateParams(UPDATED_OPREATE_PARAMS)
            .globalUniqueId(UPDATED_GLOBAL_UNIQUE_ID)
            .delFlag(UPDATED_DEL_FLAG);
        SystemLogDTO systemLogDTO = systemLogMapper.toDto(updatedSystemLog);

        restSystemLogMockMvc.perform(put("/api/system-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(systemLogDTO)))
            .andExpect(status().isOk());

        // Validate the SystemLog in the database
        List<SystemLog> systemLogList = systemLogRepository.findAll();
        assertThat(systemLogList).hasSize(databaseSizeBeforeUpdate);
        SystemLog testSystemLog = systemLogList.get(systemLogList.size() - 1);
        assertThat(testSystemLog.getOperatorName()).isEqualTo(UPDATED_OPERATOR_NAME);
        assertThat(testSystemLog.getOperatorId()).isEqualTo(UPDATED_OPERATOR_ID);
        assertThat(testSystemLog.getOperatorDeptName()).isEqualTo(UPDATED_OPERATOR_DEPT_NAME);
        assertThat(testSystemLog.getOperatorDeptId()).isEqualTo(UPDATED_OPERATOR_DEPT_ID);
        assertThat(testSystemLog.getOperateTime()).isEqualTo(UPDATED_OPERATE_TIME);
        assertThat(testSystemLog.getOperateType()).isEqualTo(UPDATED_OPERATE_TYPE);
        assertThat(testSystemLog.getContent()).isEqualTo(UPDATED_CONTENT);
        assertThat(testSystemLog.getMemo()).isEqualTo(UPDATED_MEMO);
        assertThat(testSystemLog.getOpreateParams()).isEqualTo(UPDATED_OPREATE_PARAMS);
        assertThat(testSystemLog.getGlobalUniqueId()).isEqualTo(UPDATED_GLOBAL_UNIQUE_ID);
        assertThat(testSystemLog.isDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
    }

    @Test
    @Transactional
    public void updateNonExistingSystemLog() throws Exception {
        int databaseSizeBeforeUpdate = systemLogRepository.findAll().size();

        // Create the SystemLog
        SystemLogDTO systemLogDTO = systemLogMapper.toDto(systemLog);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSystemLogMockMvc.perform(put("/api/system-logs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(systemLogDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SystemLog in the database
        List<SystemLog> systemLogList = systemLogRepository.findAll();
        assertThat(systemLogList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSystemLog() throws Exception {
        // Initialize the database
        systemLogRepository.saveAndFlush(systemLog);

        int databaseSizeBeforeDelete = systemLogRepository.findAll().size();

        // Delete the systemLog
        restSystemLogMockMvc.perform(delete("/api/system-logs/{id}", systemLog.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SystemLog> systemLogList = systemLogRepository.findAll();
        assertThat(systemLogList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
