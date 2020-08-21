package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.service.SystemLogService;
import com.digitalgd.bigdata.business.web.rest.errors.BadRequestAlertException;
import com.digitalgd.bigdata.business.service.dto.SystemLogDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.digitalgd.bigdata.business.domain.SystemLog}.
 */
@RestController
@RequestMapping("/api")
public class SystemLogResource {

    private final Logger log = LoggerFactory.getLogger(SystemLogResource.class);

    private static final String ENTITY_NAME = "bigdataBusinessSystemLog";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SystemLogService systemLogService;

    public SystemLogResource(SystemLogService systemLogService) {
        this.systemLogService = systemLogService;
    }

    /**
     * {@code POST  /system-logs} : Create a new systemLog.
     *
     * @param systemLogDTO the systemLogDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new systemLogDTO, or with status {@code 400 (Bad Request)} if the systemLog has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/system-logs")
    public ResponseEntity<SystemLogDTO> createSystemLog(@Valid @RequestBody SystemLogDTO systemLogDTO) throws URISyntaxException {
        log.debug("REST request to save SystemLog : {}", systemLogDTO);
        if (systemLogDTO.getId() != null) {
            throw new BadRequestAlertException("A new systemLog cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SystemLogDTO result = systemLogService.save(systemLogDTO);
        return ResponseEntity.created(new URI("/api/system-logs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /system-logs} : Updates an existing systemLog.
     *
     * @param systemLogDTO the systemLogDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated systemLogDTO,
     * or with status {@code 400 (Bad Request)} if the systemLogDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the systemLogDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/system-logs")
    public ResponseEntity<SystemLogDTO> updateSystemLog(@Valid @RequestBody SystemLogDTO systemLogDTO) throws URISyntaxException {
        log.debug("REST request to update SystemLog : {}", systemLogDTO);
        if (systemLogDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SystemLogDTO result = systemLogService.save(systemLogDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, systemLogDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /system-logs} : get all the systemLogs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of systemLogs in body.
     */
    @GetMapping("/system-logs")
    public ResponseEntity<List<SystemLogDTO>> getAllSystemLogs(Pageable pageable) {
        log.debug("REST request to get a page of SystemLogs");
        Page<SystemLogDTO> page = systemLogService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /system-logs/:id} : get the "id" systemLog.
     *
     * @param id the id of the systemLogDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the systemLogDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/system-logs/{id}")
    public ResponseEntity<SystemLogDTO> getSystemLog(@PathVariable Long id) {
        log.debug("REST request to get SystemLog : {}", id);
        Optional<SystemLogDTO> systemLogDTO = systemLogService.findOne(id);
        return ResponseUtil.wrapOrNotFound(systemLogDTO);
    }

    /**
     * {@code DELETE  /system-logs/:id} : delete the "id" systemLog.
     *
     * @param id the id of the systemLogDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/system-logs/{id}")
    public ResponseEntity<Void> deleteSystemLog(@PathVariable Long id) {
        log.debug("REST request to delete SystemLog : {}", id);
        systemLogService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
