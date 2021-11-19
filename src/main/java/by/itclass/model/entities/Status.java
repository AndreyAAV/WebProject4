package by.itclass.model.entities;

public enum Status {
    EXECUTED(true), NON_EXECUTED(false);

    private boolean isExecute;

    Status(boolean isExecute) {
        this.isExecute = isExecute;
    }

    public boolean isExecute() {
        return isExecute;
    }

}
