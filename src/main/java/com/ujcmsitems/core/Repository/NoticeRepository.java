package com.ujcmsitems.core.Repository;

import com.ujcmsitems.core.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author a1002
 */
public interface NoticeRepository extends JpaRepository<Notice, Integer>, JpaSpecificationExecutor {

}
