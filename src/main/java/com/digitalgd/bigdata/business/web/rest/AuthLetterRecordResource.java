package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.service.AuthLetterRecordService;
import com.digitalgd.bigdata.business.web.rest.errors.BadRequestAlertException;
import com.digitalgd.bigdata.business.service.dto.AuthLetterRecordDTO;

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
 * REST controller for managing {@link com.digitalgd.bigdata.business.domain.AuthLetterRecord}.
 */
@RestController
@RequestMapping("/api")
public class AuthLetterRecordResource {

    private final Logger log = LoggerFactory.getLogger(AuthLetterRecordResource.class);

    private static final String ENTITY_NAME = "bigdataBusinessAuthLetterRecord";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AuthLetterRecordService authLetterRecordService;

    public AuthLetterRecordResource(AuthLetterRecordService authLetterRecordService) {
        this.authLetterRecordService = authLetterRecordService;
    }

    /**
     * {@code POST  /auth-letter-records} : Create a new authLetterRecord.
     *
     * @param authLetterRecordDTO the authLetterRecordDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new authLetterRecordDTO, or with status {@code 400 (Bad Request)} if the authLetterRecord has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/auth-letter-records")
    public ResponseEntity<AuthLetterRecordDTO> createAuthLetterRecord(@Valid @RequestBody AuthLetterRecordDTO authLetterRecordDTO) throws URISyntaxException {
        log.debug("REST request to save AuthLetterRecord : {}", authLetterRecordDTO);
        if (authLetterRecordDTO.getId() != null) {
            throw new BadRequestAlertException("A new authLetterRecord cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AuthLetterRecordDTO result = authLetterRecordService.save(authLetterRecordDTO);
        return ResponseEntity.created(new URI("/api/auth-letter-records/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /auth-letter-records} : Updates an existing authLetterRecord.
     *
     * @param authLetterRecordDTO the authLetterRecordDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated authLetterRecordDTO,
     * or with status {@code 400 (Bad Request)} if the authLetterRecordDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the authLetterRecordDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/auth-letter-records")
    public ResponseEntity<AuthLetterRecordDTO> updateAuthLetterRecord(@Valid @RequestBody AuthLetterRecordDTO authLetterRecordDTO) throws URISyntaxException {
        log.debug("REST request to update AuthLetterRecord : {}", authLetterRecordDTO);
        if (authLetterRecordDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AuthLetterRecordDTO result = authLetterRecordService.save(authLetterRecordDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, authLetterRecordDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /auth-letter-records} : get all the authLetterRecords.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of authLetterRecords in body.
     */
    @GetMapping("/auth-letter-records")
    public ResponseEntity<List<AuthLetterRecordDTO>> getAllAuthLetterRecords(Pageable pageable) {
        log.debug("REST request to get a page of AuthLetterRecords");
        Page<AuthLetterRecordDTO> page = authLetterRecordService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /auth-letter-records/:id} : get the "id" authLetterRecord.
     *
     * @param id the id of the authLetterRecordDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the authLetterRecordDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/auth-letter-records/{id}")
    public ResponseEntity<AuthLetterRecordDTO> getAuthLetterRecord(@PathVariable Long id) {
        log.debug("REST request to get AuthLetterRecord : {}", id);
        Optional<AuthLetterRecordDTO> authLetterRecordDTO = authLetterRecordService.findOne(id);
        return ResponseUtil.wrapOrNotFound(authLetterRecordDTO);
    }

    /**
     * {@code DELETE  /auth-letter-records/:id} : delete the "id" authLetterRecord.
     *
     * @param id the id of the authLetterRecordDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/auth-letter-records/{id}")
    public ResponseEntity<Void> deleteAuthLetterRecord(@PathVariable Long id) {
        log.debug("REST request to delete AuthLetterRecord : {}", id);
        authLetterRecordService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
