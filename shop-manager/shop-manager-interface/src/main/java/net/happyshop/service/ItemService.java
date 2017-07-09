package net.happyshop.service;

import net.happyshop.pojo.EasyUiDataGridResult;
import net.happyshop.pojo.TbItem;

public interface ItemService {
    
    TbItem getItemById(long id);
    
    EasyUiDataGridResult<TbItem> getItemList(int page, int rows);
}
