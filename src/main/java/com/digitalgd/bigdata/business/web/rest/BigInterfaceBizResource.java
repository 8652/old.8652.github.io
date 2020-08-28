package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.service.BigInterfaceBizService;
import com.digitalgd.bigdata.business.web.rest.errors.BadRequestAlertException;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceBizDTO;

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
 * REST controller for managing {@link com.digitalgd.bigdata.business.domain.BigInterfaceBiz}.
 */
@RestController
@RequestMapping("/api")
public class BigInterfaceBizResource {

    private final Logger log = LoggerFactory.getLogger(BigInterfaceBizResource.class);

    private static final String ENTITY_NAME = "bigdataBusinessBigInterfaceBiz";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BigInterfaceBizService bigInterfaceBizService;

    public BigInterfaceBizResource(BigInterfaceBizService bigInterfaceBizService) {
        this.bigInterfaceBizService = bigInterfaceBizService;
    }

    /**
     * {@code POST  /big-interface-bizs} : Create a new bigInterfaceBiz.
     *
     * @param bigInterfaceBizDTO the bigInterfaceBizDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bigInterfaceBizDTO, or with status {@code 400 (Bad Request)} if the bigInterfaceBiz has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/big-interface-bizs")
    public ResponseEntity<BigInterfaceBizDTO> createBigInterfaceBiz(@Valid @RequestBody BigInterfaceBizDTO bigInterfaceBizDTO) throws URISyntaxException {
        log.debug("REST request to save BigInterfaceBiz : {}", bigInterfaceBizDTO);
        if (bigInterfaceBizDTO.getId() != null) {
            throw new BadRequestAlertException("A new bigInterfaceBiz cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BigInterfaceBizDTO result = bigInterfaceBizService.save(bigInterfaceBizDTO);
        return ResponseEntity.created(new URI("/api/big-interface-bizs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /big-interface-bizs} : Updates an existing bigInterfaceBiz.
     *
     * @param bigInterfaceBizDTO the bigInterfaceBizDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bigInterfaceBizDTO,
     * or with status {@code 400 (Bad Request)} if the bigInterfaceBizDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bigInterfaceBizDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/big-interface-bizs")
    public ResponseEntity<BigInterfaceBizDTO> updateBigInterfaceBiz(@Valid @RequestBody BigInterfaceBizDTO bigInterfaceBizDTO) throws URISyntaxException {
        log.debug("REST request to update BigInterfaceBiz : {}", bigInterfaceBizDTO);
        if (bigInterfaceBizDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BigInterfaceBizDTO result = bigInterfaceBizService.save(bigInterfaceBizDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, bigInterfaceBizDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /big-interface-bizs} : get all the bigInterfaceBizs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bigInterfaceBizs in body.
     */
    @GetMapping("/big-interface-bizs")
    public ResponseEntity<List<BigInterfaceBizDTO>> getAllBigInterfaceBizs(Pageable pageable) {
        log.debug("REST request to get a page of BigInterfaceBizs");
        Page<BigInterfaceBizDTO> page = bigInterfaceBizService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /big-interface-bizs/:id} : get the "id" bigInterfaceBiz.
     *
     * @param id the id of the bigInterfaceBizDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bigInterfaceBizDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/big-interface-bizs/{id}")
    public ResponseEntity<BigInterfaceBizDTO> getBigInterfaceBiz(@PathVariable Long id) {
        log.debug("REST request to get BigInterfaceBiz : {}", id);
        Optional<BigInterfaceBizDTO> bigInterfaceBizDTO = bigInterfaceBizService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bigInterfaceBizDTO);
    }

    /**
     * {@code DELETE  /big-interface-bizs/:id} : delete the "id" bigInterfaceBiz.
     *
     * @param id the id of the bigInterfaceBizDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/big-interface-bizs/{id}")
    public ResponseEntity<Void> deleteBigInterfaceBiz(@PathVariable Long id) {
        log.debug("REST request to delete BigInterfaceBiz : {}", id);
        bigInterfaceBizService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
