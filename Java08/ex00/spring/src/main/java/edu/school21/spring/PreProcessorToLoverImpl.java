package edu.school21.spring;

public class PreProcessorToLoverImpl implements PreProcessor {
    @Override
    public String changeRegister(String message) {
        return (message.toLowerCase());
    }
}
