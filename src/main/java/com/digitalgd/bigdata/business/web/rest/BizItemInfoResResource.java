package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.service.BizItemInfoResService;
import com.digitalgd.bigdata.business.web.rest.errors.BadRequestAlertException;
import com.digitalgd.bigdata.business.service.dto.BizItemInfoResDTO;

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
 * REST controller for managing {@link com.digitalgd.bigdata.business.domain.BizItemInfoRes}.
 */
@RestController
@RequestMapping("/api")
public class BizItemInfoResResource {

    private final Logger log = LoggerFactory.getLogger(BizItemInfoResResource.class);

    private static final String ENTITY_NAME = "bigdataBusinessBizItemInfoRes";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BizItemInfoResService bizItemInfoResService;

    public BizItemInfoResResource(BizItemInfoResService bizItemInfoResService) {
        this.bizItemInfoResService = bizItemInfoResService;
    }

    /**
     * {@code POST  /biz-item-info-res} : Create a new bizItemInfoRes.
     *
     * @param bizItemInfoResDTO the bizItemInfoResDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bizItemInfoResDTO, or with status {@code 400 (Bad Request)} if the bizItemInfoRes has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/biz-item-info-res")
    public ResponseEntity<BizItemInfoResDTO> createBizItemInfoRes(@Valid @RequestBody BizItemInfoResDTO bizItemInfoResDTO) throws URISyntaxException {
        log.debug("REST request to save BizItemInfoRes : {}", bizItemInfoResDTO);
        if (bizItemInfoResDTO.getId() != null) {
            throw new BadRequestAlertException("A new bizItemInfoRes cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BizItemInfoResDTO result = bizItemInfoResService.save(bizItemInfoResDTO);
        return ResponseEntity.created(new URI("/api/biz-item-info-res/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /biz-item-info-res} : Updates an existing bizItemInfoRes.
     *
     * @param bizItemInfoResDTO the bizItemInfoResDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bizItemInfoResDTO,
     * or with status {@code 400 (Bad Request)} if the bizItemInfoResDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bizItemInfoResDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/biz-item-info-res")
    public ResponseEntity<BizItemInfoResDTO> updateBizItemInfoRes(@Valid @RequestBody BizItemInfoResDTO bizItemInfoResDTO) throws URISyntaxException {
        log.debug("REST request to update BizItemInfoRes : {}", bizItemInfoResDTO);
        if (bizItemInfoResDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BizItemInfoResDTO result = bizItemInfoResService.save(bizItemInfoResDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, bizItemInfoResDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /biz-item-info-res} : get all the bizItemInfoRes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bizItemInfoRes in body.
     */
    @GetMapping("/biz-item-info-res")
    public ResponseEntity<List<BizItemInfoResDTO>> getAllBizItemInfoRes(Pageable pageable) {
        log.debug("REST request to get a page of BizItemInfoRes");
        Page<BizItemInfoResDTO> page = bizItemInfoResService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /biz-item-info-res/:id} : get the "id" bizItemInfoRes.
     *
     * @param id the id of the bizItemInfoResDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bizItemInfoResDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/biz-item-info-res/{id}")
    public ResponseEntity<BizItemInfoResDTO> getBizItemInfoRes(@PathVariable Long id) {
        log.debug("REST request to get BizItemInfoRes : {}", id);
        Optional<BizItemInfoResDTO> bizItemInfoResDTO = bizItemInfoResService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bizItemInfoResDTO);
    }

    /**
     * {@code DELETE  /biz-item-info-res/:id} : delete the "id" bizItemInfoRes.
     *
     * @param id the id of the bizItemInfoResDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/biz-item-info-res/{id}")
    public ResponseEntity<Void> deleteBizItemInfoRes(@PathVariable Long id) {
        log.debug("REST request to delete BizItemInfoRes : {}", id);
        bizItemInfoResService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
