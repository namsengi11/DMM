class OutOfRangeException extends Exception {
    private String errorMessage;
    
    OutOfRangeException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }
}

