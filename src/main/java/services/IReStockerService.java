package services;

import entity.Store;

public interface IReStockerService {
    void restockProduct(Store store, int quantity);
}
