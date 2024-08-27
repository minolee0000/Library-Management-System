package Entity;

public class CategoryEntity {
    private String categoryID;
    private String categoryName;
    private Integer qtyOfBooks;
    
    public CategoryEntity() {
    }

    
    public CategoryEntity(String categoryID, String categoryName, Integer qtyOfBooks) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.qtyOfBooks = qtyOfBooks;
    }


    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getQtyOfBooks() {
        return qtyOfBooks;
    }

    public void setQtyOfBooks(Integer qtyOfBooks) {
        this.qtyOfBooks = qtyOfBooks;
    }

    @Override
    public String toString() {
        return "CategoryEntity [categoryID=" + categoryID + ", categoryName=" + categoryName + ", qtyOfBooks="
                + qtyOfBooks + "]";
    }


    public Object getAvailability() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAvailability'");
    }

    
}
