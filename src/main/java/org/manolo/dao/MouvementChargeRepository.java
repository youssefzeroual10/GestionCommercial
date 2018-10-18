package org.manolo.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.manolo.entities.Defectueuse;
import org.manolo.entities.Mouvement;
import org.manolo.entities.MouvementCharge;
import org.manolo.entities.Promotion;
import org.manolo.entities.Sortie;
import org.manolo.metier.PageMouvement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MouvementChargeRepository extends JpaRepository<MouvementCharge, Long>{
	}
