package config;

public enum BlogTabs {
    NEWS ("NEWS"),
    REAL_STORIES ("REAL STORIES"),
    MATERIALS ("MATERIALS"),
    HARD_SKILLS ("HARD SKILLS"),
    SOFT_SKILLS ("SOFT SKILLS"),
    EVENTS ("EVENTS");

    private String title;

    BlogTabs(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
