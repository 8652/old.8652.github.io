package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.service.BigInterfaceLogService;
import com.digitalgd.bigdata.business.web.rest.errors.BadRequestAlertException;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceLogDTO;

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
 * REST controller for managing {@link com.digitalgd.bigdata.business.domain.BigInterfaceLog}.
 */
@RestController
@RequestMapping("/api")
public class BigInterfaceLogResource {

    private final Logger log = LoggerFactory.getLogger(BigInterfaceLogResource.class);

    private static final String ENTITY_NAME = "bigdataBusinessBigInterfaceLog";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BigInterfaceLogService bigInterfaceLogService;

    public BigInterfaceLogResource(BigInterfaceLogService bigInterfaceLogService) {
        this.bigInterfaceLogService = bigInterfaceLogService;
    }

    /**
     * {@code POST  /big-interface-logs} : Create a new bigInterfaceLog.
     *
     * @param bigInterfaceLogDTO the bigInterfaceLogDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bigInterfaceLogDTO, or with status {@code 400 (Bad Request)} if the bigInterfaceLog has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/big-interface-logs")
    public ResponseEntity<BigInterfaceLogDTO> createBigInterfaceLog(@Valid @RequestBody BigInterfaceLogDTO bigInterfaceLogDTO) throws URISyntaxException {
        log.debug("REST request to save BigInterfaceLog : {}", bigInterfaceLogDTO);
        if (bigInterfaceLogDTO.getId() != null) {
            throw new BadRequestAlertException("A new bigInterfaceLog cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BigInterfaceLogDTO result = bigInterfaceLogService.save(bigInterfaceLogDTO);
        return ResponseEntity.created(new URI("/api/big-interface-logs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /big-interface-logs} : Updates an existing bigInterfaceLog.
     *
     * @param bigInterfaceLogDTO the bigInterfaceLogDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bigInterfaceLogDTO,
     * or with status {@code 400 (Bad Request)} if the bigInterfaceLogDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bigInterfaceLogDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/big-interface-logs")
    public ResponseEntity<BigInterfaceLogDTO> updateBigInterfaceLog(@Valid @RequestBody BigInterfaceLogDTO bigInterfaceLogDTO) throws URISyntaxException {
        log.debug("REST request to update BigInterfaceLog : {}", bigInterfaceLogDTO);
        if (bigInterfaceLogDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BigInterfaceLogDTO result = bigInterfaceLogService.save(bigInterfaceLogDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, bigInterfaceLogDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /big-interface-logs} : get all the bigInterfaceLogs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bigInterfaceLogs in body.
     */
    @GetMapping("/big-interface-logs")
    public ResponseEntity<List<BigInterfaceLogDTO>> getAllBigInterfaceLogs(Pageable pageable) {
        log.debug("REST request to get a page of BigInterfaceLogs");
        Page<BigInterfaceLogDTO> page = bigInterfaceLogService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /big-interface-logs/:id} : get the "id" bigInterfaceLog.
     *
     * @param id the id of the bigInterfaceLogDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bigInterfaceLogDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/big-interface-logs/{id}")
    public ResponseEntity<BigInterfaceLogDTO> getBigInterfaceLog(@PathVariable Long id) {
        log.debug("REST request to get BigInterfaceLog : {}", id);
        Optional<BigInterfaceLogDTO> bigInterfaceLogDTO = bigInterfaceLogService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bigInterfaceLogDTO);
    }

    /**
     * {@code DELETE  /big-interface-logs/:id} : delete the "id" bigInterfaceLog.
     *
     * @param id the id of the bigInterfaceLogDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/big-interface-logs/{id}")
    public ResponseEntity<Void> deleteBigInterfaceLog(@PathVariable Long id) {
        log.debug("REST request to delete BigInterfaceLog : {}", id);
        bigInterfaceLogService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
