package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.service.PairContractFileService;
import com.digitalgd.bigdata.business.web.rest.errors.BadRequestAlertException;
import com.digitalgd.bigdata.business.service.dto.PairContractFileDTO;

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
 * REST controller for managing {@link com.digitalgd.bigdata.business.domain.PairContractFile}.
 */
@RestController
@RequestMapping("/api")
public class PairContractFileResource {

    private final Logger log = LoggerFactory.getLogger(PairContractFileResource.class);

    private static final String ENTITY_NAME = "bigdataBusinessPairContractFile";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PairContractFileService pairContractFileService;

    public PairContractFileResource(PairContractFileService pairContractFileService) {
        this.pairContractFileService = pairContractFileService;
    }

    /**
     * {@code POST  /pair-contract-files} : Create a new pairContractFile.
     *
     * @param pairContractFileDTO the pairContractFileDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pairContractFileDTO, or with status {@code 400 (Bad Request)} if the pairContractFile has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pair-contract-files")
    public ResponseEntity<PairContractFileDTO> createPairContractFile(@Valid @RequestBody PairContractFileDTO pairContractFileDTO) throws URISyntaxException {
        log.debug("REST request to save PairContractFile : {}", pairContractFileDTO);
        if (pairContractFileDTO.getId() != null) {
            throw new BadRequestAlertException("A new pairContractFile cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PairContractFileDTO result = pairContractFileService.save(pairContractFileDTO);
        return ResponseEntity.created(new URI("/api/pair-contract-files/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /pair-contract-files} : Updates an existing pairContractFile.
     *
     * @param pairContractFileDTO the pairContractFileDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pairContractFileDTO,
     * or with status {@code 400 (Bad Request)} if the pairContractFileDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pairContractFileDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pair-contract-files")
    public ResponseEntity<PairContractFileDTO> updatePairContractFile(@Valid @RequestBody PairContractFileDTO pairContractFileDTO) throws URISyntaxException {
        log.debug("REST request to update PairContractFile : {}", pairContractFileDTO);
        if (pairContractFileDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PairContractFileDTO result = pairContractFileService.save(pairContractFileDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pairContractFileDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /pair-contract-files} : get all the pairContractFiles.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pairContractFiles in body.
     */
    @GetMapping("/pair-contract-files")
    public ResponseEntity<List<PairContractFileDTO>> getAllPairContractFiles(Pageable pageable) {
        log.debug("REST request to get a page of PairContractFiles");
        Page<PairContractFileDTO> page = pairContractFileService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /pair-contract-files/:id} : get the "id" pairContractFile.
     *
     * @param id the id of the pairContractFileDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pairContractFileDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pair-contract-files/{id}")
    public ResponseEntity<PairContractFileDTO> getPairContractFile(@PathVariable Long id) {
        log.debug("REST request to get PairContractFile : {}", id);
        Optional<PairContractFileDTO> pairContractFileDTO = pairContractFileService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pairContractFileDTO);
    }

    /**
     * {@code DELETE  /pair-contract-files/:id} : delete the "id" pairContractFile.
     *
     * @param id the id of the pairContractFileDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pair-contract-files/{id}")
    public ResponseEntity<Void> deletePairContractFile(@PathVariable Long id) {
        log.debug("REST request to delete PairContractFile : {}", id);
        pairContractFileService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
