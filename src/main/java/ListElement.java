public class ListElement implements IListElement{
    private int id;
    private IListElement next;

    ListElement(int id){
        this.id = id;
    }

    void setNext(IListElement next) {
        this.next = next;
    }

    @Override
    public IListElement getNext() {
        return this.next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListElement that = (ListElement) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public String toString() {
        return "ListElement{" +
                "id=" + id +
                '}';
    }
}
