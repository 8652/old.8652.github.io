package com.digitalgd.bigdata.business.web.rest;

import com.digitalgd.bigdata.business.service.BigInterfaceListService;
import com.digitalgd.bigdata.business.web.rest.errors.BadRequestAlertException;
import com.digitalgd.bigdata.business.service.dto.BigInterfaceListDTO;

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
 * REST controller for managing {@link com.digitalgd.bigdata.business.domain.BigInterfaceList}.
 */
@RestController
@RequestMapping("/api")
public class BigInterfaceListResource {

    private final Logger log = LoggerFactory.getLogger(BigInterfaceListResource.class);

    private static final String ENTITY_NAME = "bigdataBusinessBigInterfaceList";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BigInterfaceListService bigInterfaceListService;

    public BigInterfaceListResource(BigInterfaceListService bigInterfaceListService) {
        this.bigInterfaceListService = bigInterfaceListService;
    }

    /**
     * {@code POST  /big-interface-lists} : Create a new bigInterfaceList.
     *
     * @param bigInterfaceListDTO the bigInterfaceListDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bigInterfaceListDTO, or with status {@code 400 (Bad Request)} if the bigInterfaceList has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/big-interface-lists")
    public ResponseEntity<BigInterfaceListDTO> createBigInterfaceList(@Valid @RequestBody BigInterfaceListDTO bigInterfaceListDTO) throws URISyntaxException {
        log.debug("REST request to save BigInterfaceList : {}", bigInterfaceListDTO);
        if (bigInterfaceListDTO.getId() != null) {
            throw new BadRequestAlertException("A new bigInterfaceList cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BigInterfaceListDTO result = bigInterfaceListService.save(bigInterfaceListDTO);
        return ResponseEntity.created(new URI("/api/big-interface-lists/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /big-interface-lists} : Updates an existing bigInterfaceList.
     *
     * @param bigInterfaceListDTO the bigInterfaceListDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bigInterfaceListDTO,
     * or with status {@code 400 (Bad Request)} if the bigInterfaceListDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bigInterfaceListDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/big-interface-lists")
    public ResponseEntity<BigInterfaceListDTO> updateBigInterfaceList(@Valid @RequestBody BigInterfaceListDTO bigInterfaceListDTO) throws URISyntaxException {
        log.debug("REST request to update BigInterfaceList : {}", bigInterfaceListDTO);
        if (bigInterfaceListDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BigInterfaceListDTO result = bigInterfaceListService.save(bigInterfaceListDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, bigInterfaceListDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /big-interface-lists} : get all the bigInterfaceLists.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bigInterfaceLists in body.
     */
    @GetMapping("/big-interface-lists")
    public ResponseEntity<List<BigInterfaceListDTO>> getAllBigInterfaceLists(Pageable pageable) {
        log.debug("REST request to get a page of BigInterfaceLists");
        Page<BigInterfaceListDTO> page = bigInterfaceListService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /big-interface-lists/:id} : get the "id" bigInterfaceList.
     *
     * @param id the id of the bigInterfaceListDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bigInterfaceListDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/big-interface-lists/{id}")
    public ResponseEntity<BigInterfaceListDTO> getBigInterfaceList(@PathVariable Long id) {
        log.debug("REST request to get BigInterfaceList : {}", id);
        Optional<BigInterfaceListDTO> bigInterfaceListDTO = bigInterfaceListService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bigInterfaceListDTO);
    }

    /**
     * {@code DELETE  /big-interface-lists/:id} : delete the "id" bigInterfaceList.
     *
     * @param id the id of the bigInterfaceListDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/big-interface-lists/{id}")
    public ResponseEntity<Void> deleteBigInterfaceList(@PathVariable Long id) {
        log.debug("REST request to delete BigInterfaceList : {}", id);
        bigInterfaceListService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
