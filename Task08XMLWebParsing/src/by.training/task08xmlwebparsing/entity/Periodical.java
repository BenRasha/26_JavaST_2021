package entity;

public class Periodical {

    private String id;
    private String title;
    private String paperType;
    private String periodicity;
    private Characteristic characteristic = new Characteristic();

    public Periodical() {}

    public Periodical(String ID, String title, String paperType, String periodicity, Characteristic characteristic) {
        this.id = ID;
        this.title = title;
        this.paperType = paperType;
        this.periodicity = periodicity;
        this.characteristic = characteristic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nID: ");
        sb.append(id).append("\nTitle: ").append(title);
        sb.append("\nType: ").append(paperType).append("\nMonthly: ");
        sb.append(periodicity).append(characteristic);
        return sb.toString();
    }

    public class Characteristic {
        private boolean isColourful;
        private int capacity;
        private String cover;

        public Characteristic() {}

        public Characteristic(boolean isColourful, int capacity, String cover) {
            this.isColourful = isColourful;
            this.capacity = capacity;
            this.cover = cover;
        }

        public boolean isColourful() {
            return isColourful;
        }

        public void setColourful(boolean colourful) {
            isColourful = colourful;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\nCharacteristics:\n\tColour: ");
            sb.append(isColourful).append("\n\tCapacity: ").append(capacity);
            sb.append("\n\tCover: ").append(cover).append('\n');
            return sb.toString();
        }
    }
}
