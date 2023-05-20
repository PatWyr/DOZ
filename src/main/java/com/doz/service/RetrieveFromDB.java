package com.doz.service;

public interface RetrieveFromDB <T, S>{
    T retrieve(S param);
}
