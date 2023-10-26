package com.ujcmsitems.core.Repository;

import com.ujcmsitems.core.domain.Notice;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author a1002
 */
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>, JpaSpecificationExecutor {
    @Query(value="SELECT * FROM notice WHERE first_target = ? ORDER BY id DESC LIMIT 6",nativeQuery = true)

    List<Notice> queryNoticeFour(String firstTarget);

    @Query(value="SELECT * FROM notice ORDER BY id DESC",nativeQuery = true)
    List<Notice> queryAllNotice();
//
//    //多条件模糊查询
//    @Select("select * from  user where notice_title like #{noticeTitle} and notice_content like #{noticeContent} limit #{pageNum} , #{pageSize}")
//    List<Notice> selectPage(Integer pageNum, Integer pageSize, String noticeTitle, String noticeContent);
//
//    //多条件模糊查询总条数
//    @Select("select count(*) from  user where notice_title like #{noticeTitle} and notice_content like #{noticeContent}")
//    Integer selectTotal(String noticeTitle, String noticeContent);

}
