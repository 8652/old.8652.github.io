package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.service.AuthLetterTemplateService;
import com.digitalgd.bigdata.business.web.rest.errors.BadRequestAlertException;
import com.digitalgd.bigdata.business.service.dto.AuthLetterTemplateDTO;

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
 * REST controller for managing {@link com.digitalgd.bigdata.business.domain.AuthLetterTemplate}.
 */
@RestController
@RequestMapping("/api")
public class AuthLetterTemplateResource {

    private final Logger log = LoggerFactory.getLogger(AuthLetterTemplateResource.class);

    private static final String ENTITY_NAME = "bigdataBusinessAuthLetterTemplate";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AuthLetterTemplateService authLetterTemplateService;

    public AuthLetterTemplateResource(AuthLetterTemplateService authLetterTemplateService) {
        this.authLetterTemplateService = authLetterTemplateService;
    }

    /**
     * {@code POST  /auth-letter-templates} : Create a new authLetterTemplate.
     *
     * @param authLetterTemplateDTO the authLetterTemplateDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new authLetterTemplateDTO, or with status {@code 400 (Bad Request)} if the authLetterTemplate has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/auth-letter-templates")
    public ResponseEntity<AuthLetterTemplateDTO> createAuthLetterTemplate(@Valid @RequestBody AuthLetterTemplateDTO authLetterTemplateDTO) throws URISyntaxException {
        log.debug("REST request to save AuthLetterTemplate : {}", authLetterTemplateDTO);
        if (authLetterTemplateDTO.getId() != null) {
            throw new BadRequestAlertException("A new authLetterTemplate cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AuthLetterTemplateDTO result = authLetterTemplateService.save(authLetterTemplateDTO);
        return ResponseEntity.created(new URI("/api/auth-letter-templates/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /auth-letter-templates} : Updates an existing authLetterTemplate.
     *
     * @param authLetterTemplateDTO the authLetterTemplateDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated authLetterTemplateDTO,
     * or with status {@code 400 (Bad Request)} if the authLetterTemplateDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the authLetterTemplateDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/auth-letter-templates")
    public ResponseEntity<AuthLetterTemplateDTO> updateAuthLetterTemplate(@Valid @RequestBody AuthLetterTemplateDTO authLetterTemplateDTO) throws URISyntaxException {
        log.debug("REST request to update AuthLetterTemplate : {}", authLetterTemplateDTO);
        if (authLetterTemplateDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AuthLetterTemplateDTO result = authLetterTemplateService.save(authLetterTemplateDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, authLetterTemplateDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /auth-letter-templates} : get all the authLetterTemplates.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of authLetterTemplates in body.
     */
    @GetMapping("/auth-letter-templates")
    public ResponseEntity<List<AuthLetterTemplateDTO>> getAllAuthLetterTemplates(Pageable pageable) {
        log.debug("REST request to get a page of AuthLetterTemplates");
        Page<AuthLetterTemplateDTO> page = authLetterTemplateService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /auth-letter-templates/:id} : get the "id" authLetterTemplate.
     *
     * @param id the id of the authLetterTemplateDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the authLetterTemplateDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/auth-letter-templates/{id}")
    public ResponseEntity<AuthLetterTemplateDTO> getAuthLetterTemplate(@PathVariable Long id) {
        log.debug("REST request to get AuthLetterTemplate : {}", id);
        Optional<AuthLetterTemplateDTO> authLetterTemplateDTO = authLetterTemplateService.findOne(id);
        return ResponseUtil.wrapOrNotFound(authLetterTemplateDTO);
    }

    /**
     * {@code DELETE  /auth-letter-templates/:id} : delete the "id" authLetterTemplate.
     *
     * @param id the id of the authLetterTemplateDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/auth-letter-templates/{id}")
    public ResponseEntity<Void> deleteAuthLetterTemplate(@PathVariable Long id) {
        log.debug("REST request to delete AuthLetterTemplate : {}", id);
        authLetterTemplateService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
