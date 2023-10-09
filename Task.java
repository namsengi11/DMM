package project.Tasks;

class Task {
    private String name;
    private String description;
    private int urgence;
    private int importance;

    protected Task(String name, String description, int urgence, int importance) {
        this.name = name;
        this.description = description;
        this.urgence = urgence;
        this.importance = importance;
    }

    static Task createTask(String name, String description, int urgence, int importance) throws OutOfRangeException {
        if (urgence > 10 || urgence < -10) {
            throw new OutOfRangeException("Urgence is outside of -10 ~ 10 range");
        } else if (importance > 10 || importance < -10) {
            throw new OutOfRangeException("importance is outside of -10 ~ 10 range");
        } else {
            return new Task (name, description, urgence, importance);
        }
    }

    @Override
    public String toString() {
        return String.format("Imp[%d] Urg[%d] %s: %s", importance, urgence, name, description);
    }
}