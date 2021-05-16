package com.vimarsh.repository;

import com.vimarsh.model.Modal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Modal, Long> {
}
