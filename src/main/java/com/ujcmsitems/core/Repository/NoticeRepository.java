package com.ujcmsitems.core.Repository;

import com.ujcmsitems.core.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author a1002
 */
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>, JpaSpecificationExecutor {
    @Query(value="SELECT * FROM notice WHERE first_target = ? ORDER BY id DESC LIMIT 4",nativeQuery = true)
    List<Notice> queryNoticeFour(String firstTarget);


}
