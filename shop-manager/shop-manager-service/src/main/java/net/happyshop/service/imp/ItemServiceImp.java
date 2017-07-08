package net.happyshop.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.happyshop.mapper.TbItemMapper;
import net.happyshop.pojo.TbItem;
import net.happyshop.pojo.TbItemExample;
import net.happyshop.pojo.TbItemExample.Criteria;
import net.happyshop.service.ItemService;

@Service
public class ItemServiceImp implements ItemService{
    
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long id) {
        TbItemExample example = new TbItemExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<TbItem> items = itemMapper.selectByExample(example);
        if ((items != null) && (items.size() > 0)) {
            return items.get(0);
        }
        return null;
    }
    
}
