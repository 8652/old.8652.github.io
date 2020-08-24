package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.service.PairContractService;
import com.digitalgd.bigdata.business.web.rest.errors.BadRequestAlertException;
import com.digitalgd.bigdata.business.service.dto.PairContractDTO;

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
 * REST controller for managing {@link com.digitalgd.bigdata.business.domain.PairContract}.
 */
@RestController
@RequestMapping("/api")
public class PairContractResource {

    private final Logger log = LoggerFactory.getLogger(PairContractResource.class);

    private static final String ENTITY_NAME = "bigdataBusinessPairContract";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PairContractService pairContractService;

    public PairContractResource(PairContractService pairContractService) {
        this.pairContractService = pairContractService;
    }

    /**
     * {@code POST  /pair-contracts} : Create a new pairContract.
     *
     * @param pairContractDTO the pairContractDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pairContractDTO, or with status {@code 400 (Bad Request)} if the pairContract has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pair-contracts")
    public ResponseEntity<PairContractDTO> createPairContract(@Valid @RequestBody PairContractDTO pairContractDTO) throws URISyntaxException {
        log.debug("REST request to save PairContract : {}", pairContractDTO);
        if (pairContractDTO.getId() != null) {
            throw new BadRequestAlertException("A new pairContract cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PairContractDTO result = pairContractService.save(pairContractDTO);
        return ResponseEntity.created(new URI("/api/pair-contracts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /pair-contracts} : Updates an existing pairContract.
     *
     * @param pairContractDTO the pairContractDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pairContractDTO,
     * or with status {@code 400 (Bad Request)} if the pairContractDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pairContractDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pair-contracts")
    public ResponseEntity<PairContractDTO> updatePairContract(@Valid @RequestBody PairContractDTO pairContractDTO) throws URISyntaxException {
        log.debug("REST request to update PairContract : {}", pairContractDTO);
        if (pairContractDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PairContractDTO result = pairContractService.save(pairContractDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pairContractDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /pair-contracts} : get all the pairContracts.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pairContracts in body.
     */
    @GetMapping("/pair-contracts")
    public ResponseEntity<List<PairContractDTO>> getAllPairContracts(Pageable pageable) {
        log.debug("REST request to get a page of PairContracts");
        Page<PairContractDTO> page = pairContractService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /pair-contracts/:id} : get the "id" pairContract.
     *
     * @param id the id of the pairContractDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pairContractDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pair-contracts/{id}")
    public ResponseEntity<PairContractDTO> getPairContract(@PathVariable Long id) {
        log.debug("REST request to get PairContract : {}", id);
        Optional<PairContractDTO> pairContractDTO = pairContractService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pairContractDTO);
    }

    /**
     * {@code DELETE  /pair-contracts/:id} : delete the "id" pairContract.
     *
     * @param id the id of the pairContractDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pair-contracts/{id}")
    public ResponseEntity<Void> deletePairContract(@PathVariable Long id) {
        log.debug("REST request to delete PairContract : {}", id);
        pairContractService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
