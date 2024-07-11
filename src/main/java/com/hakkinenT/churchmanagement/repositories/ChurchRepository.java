package com.hakkinenT.churchmanagement.repositories;

import com.hakkinenT.churchmanagement.models.entities.Church;
import com.hakkinenT.churchmanagement.models.projections.ChurchProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChurchRepository extends JpaRepository<Church, String> {
    //SELECT * FROM tb_church WHERE tb_church.cnpj='66776441000198' OR tb_church.mother_church_cnpj='66776441000198'

    @Query(nativeQuery = true,
    value = """
            SELECT *
            FROM tb_church AS c
            WHERE c.cnpj=:cnpj OR c.mother_church_cnpj=:cnpj
            """)
    List<ChurchProjection> searchChurchMotherAndCongregations(String cnpj);

    /*
    * SELECT mother.cnpj AS mother_church_cnpj, mother.name AS mother_name, mother.email AS mother_email, congregation.cnpj AS cnpj, congregation.name AS name, congregation.email AS email
FROM tb_church AS congregation
INNER JOIN tb_church AS mother ON congregation.mother_church_cnpj=mother.cnpj
* */
}
