package ir.baharn.demobaharan.model;

public enum Duration {
    TERM_AVAL("ترم اول"),
    TERM_DOVOM("ترم دوم"),
    TERM_SEVOM("ترم سوم"),
    TERM_CHAHAROM("ترم چهارم"),
    TERM_PANJOM("ترم پنجم"),
    TERM_SHESHOM("ترم ششم"),
    TERM_HAFTOM("ترم هفتم"),
    TERM_HASHTOM("ترم هشتم"),
    TERM_NOHOM("ترم نهم"),
    TERM_DAHOM("ترم دهم");

    private final String title;

    Duration(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
