package com.exemplo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class TestBase {

    private AutoCloseable closeable;

    @BeforeEach
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void releaseMocks() {
        try {            
        closeable.close();
        } catch (Exception e) {
          System.out.println(String.format("[releaseMocks]: %s", e.getMessage()));
        }
    }
}
