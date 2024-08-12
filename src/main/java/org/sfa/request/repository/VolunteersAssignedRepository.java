package org.sfa.request.repository;

import org.sfa.request.model.entity.Request;
import org.sfa.request.model.entity.VolunteersAssigned;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteersAssignedRepository extends JpaRepository<VolunteersAssigned, String> {

    @Query("SELECT va FROM VolunteersAssigned va WHERE va.user.userId = :requesterId")
    Page<VolunteersAssigned> findAllManagedRequests(String requesterId, Pageable pageable);
}
