package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.service.PairContactFileService;
import com.digitalgd.bigdata.business.web.rest.errors.BadRequestAlertException;
import com.digitalgd.bigdata.business.service.dto.PairContactFileDTO;

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
 * REST controller for managing {@link com.digitalgd.bigdata.business.domain.PairContactFile}.
 */
@RestController
@RequestMapping("/api")
public class PairContactFileResource {

    private final Logger log = LoggerFactory.getLogger(PairContactFileResource.class);

    private static final String ENTITY_NAME = "bigdataBusinessPairContactFile";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PairContactFileService pairContactFileService;

    public PairContactFileResource(PairContactFileService pairContactFileService) {
        this.pairContactFileService = pairContactFileService;
    }

    /**
     * {@code POST  /pair-contact-files} : Create a new pairContactFile.
     *
     * @param pairContactFileDTO the pairContactFileDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pairContactFileDTO, or with status {@code 400 (Bad Request)} if the pairContactFile has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pair-contact-files")
    public ResponseEntity<PairContactFileDTO> createPairContactFile(@Valid @RequestBody PairContactFileDTO pairContactFileDTO) throws URISyntaxException {
        log.debug("REST request to save PairContactFile : {}", pairContactFileDTO);
        if (pairContactFileDTO.getId() != null) {
            throw new BadRequestAlertException("A new pairContactFile cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PairContactFileDTO result = pairContactFileService.save(pairContactFileDTO);
        return ResponseEntity.created(new URI("/api/pair-contact-files/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /pair-contact-files} : Updates an existing pairContactFile.
     *
     * @param pairContactFileDTO the pairContactFileDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pairContactFileDTO,
     * or with status {@code 400 (Bad Request)} if the pairContactFileDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pairContactFileDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pair-contact-files")
    public ResponseEntity<PairContactFileDTO> updatePairContactFile(@Valid @RequestBody PairContactFileDTO pairContactFileDTO) throws URISyntaxException {
        log.debug("REST request to update PairContactFile : {}", pairContactFileDTO);
        if (pairContactFileDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PairContactFileDTO result = pairContactFileService.save(pairContactFileDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pairContactFileDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /pair-contact-files} : get all the pairContactFiles.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pairContactFiles in body.
     */
    @GetMapping("/pair-contact-files")
    public ResponseEntity<List<PairContactFileDTO>> getAllPairContactFiles(Pageable pageable) {
        log.debug("REST request to get a page of PairContactFiles");
        Page<PairContactFileDTO> page = pairContactFileService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /pair-contact-files/:id} : get the "id" pairContactFile.
     *
     * @param id the id of the pairContactFileDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pairContactFileDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pair-contact-files/{id}")
    public ResponseEntity<PairContactFileDTO> getPairContactFile(@PathVariable Long id) {
        log.debug("REST request to get PairContactFile : {}", id);
        Optional<PairContactFileDTO> pairContactFileDTO = pairContactFileService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pairContactFileDTO);
    }

    /**
     * {@code DELETE  /pair-contact-files/:id} : delete the "id" pairContactFile.
     *
     * @param id the id of the pairContactFileDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pair-contact-files/{id}")
    public ResponseEntity<Void> deletePairContactFile(@PathVariable Long id) {
        log.debug("REST request to delete PairContactFile : {}", id);
        pairContactFileService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
