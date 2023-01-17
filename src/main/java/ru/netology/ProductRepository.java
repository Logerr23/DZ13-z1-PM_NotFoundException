package ru.netology;

public class ProductRepository {
    private Product[] products = new Product[0];


    public void saveProduct(Product product) {
        if(findById(product.getId()) != null){
            throw new AlreadyExistsException("Продукт с id: " + product.getId() + " ,уже существует");

        }
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;

    }


    public Product[] getProducts() {
        return products;
    }

    public Product findById(int id) {
        for (Product product: products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if(findById(id) == null){
            throw new NotFoundException("Продукта с id: " + id + ", не существует.");
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product i: products) {
            if (i.getId() != id) {
                tmp[copyToIndex] = i;
                copyToIndex++;
            }

        }
        products = tmp;
    }

}
