package com.compiler.main;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CodeRepository extends CrudRepository<CodeFile, Integer> {}
