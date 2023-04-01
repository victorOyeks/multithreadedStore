package services;

import entity.Applicant;
import entity.Cashier;


public interface IManagerService {
    void hire (Applicant applicant);
    void fire(Cashier cashier);

}
