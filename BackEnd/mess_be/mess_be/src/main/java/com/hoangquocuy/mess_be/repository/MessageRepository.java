package com.hoangquocuy.mess_be.repository;

import com.hoangquocuy.mess_be.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
    List<MessageEntity> findByFromBy_IdAndToBy_IdAndToBy_IdAndFromBy_Id(int id1, int id2, int id3,int id4);

    @Query(nativeQuery = true, value = "SELECT * FROM message " +
            "where from_by = ?1 and to_by = ?2 or from_by = ?3 " +
            "and to_by = ?4 order by time_send asc")
    List<MessageEntity> getMessages(int id1, int id2, int id3, int id4);
}
