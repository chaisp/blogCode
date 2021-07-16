package com.example.demo.refactor.IdGeneratorModel.Second;

import com.example.demo.refactor.IdGeneratorModel.Fourth.IdGenerationFailureException;

public interface IdGenerator {
    String generate() throws IdGenerationFailureException;
}
