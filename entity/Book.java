package entity;

public class Book {
    private String id;
    private String title;
    private boolean isIssued;
    private String issuedToUserId;
    private int price;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
        this.issuedToUserId = null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public void setIssuedToUserId(String issuedToUserId) {
        this.issuedToUserId = issuedToUserId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public String getIssuedToUserId() {
        return issuedToUserId;
    }

    public void issueTo(String userId) {
        this.isIssued = true;
        this.issuedToUserId = userId;
    }

    public void returnBook() {
        this.isIssued = false;
        this.issuedToUserId = null;
    }

    @Override
    public String toString() {
        return "Book{id='" + id + "', title='" + title + "', issued=" + isIssued +
                (isIssued ? ", issuedTo='" + issuedToUserId + "'}" : "'}");
    }
}
