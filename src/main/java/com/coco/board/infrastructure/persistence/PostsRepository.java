package com.coco.board.infrastructure.persistence;

import com.coco.board.domain.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Modifying
    @Query("UPDATE Posts p SET p.view = p.view + 1 WHERE p.id = :id")
    int updateView(@Param("id") Long id);

    Page<Posts> findByTitleContaining(@Param("keyword") String keyword, Pageable pageable);
}