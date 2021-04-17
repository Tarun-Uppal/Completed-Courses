package com.company;

public class MyLinkedList implements NodeList{

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null){
            //theList was empty so ot became the head of the list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = (currentItem.compareTo(newItem));
            if(comparison<0){
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }else{
                    //there is no next,so insert at end of list
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            }else if(comparison >0){
                //new item isLess, insert before
                if(currentItem.previous() != null){
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                }else{
                    //the node without a previous
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            }else{
                //equal
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item!=null){
            System.out.println("deleting item" + item.getValue());
        }

        ListItem currentItem = this.root;
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null){
            System.out.println("the list is empty");
        }else{
            while(root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
