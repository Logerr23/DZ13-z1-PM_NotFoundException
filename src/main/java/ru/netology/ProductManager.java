package ru.netology;

public class ProductManager {
    private ProductRepository repo;

    public  ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.saveProduct(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repo.getProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];  //  Заранее извиняюсь,
                for (int i = 0; i < result.length; i++) {        //  не смог придумать как
                    tmp[i] = result[i];                          //  по другому можно было сделать
                }                                                //  длинну массива resoult
                tmp [tmp.length -1] = product;                   //  зависимой от количества
                result = tmp;                                    //  совпадений в поиске((
            }
        }
        return result;
    }





    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }


}
