/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('.form-disabled').on('submit',function(){
    var self=$(this),
    button = self.find('input[type="submit"],button');
    submitvalue= button.data(submit-value);
    
    button.attr('disabled','disabled').val(submitValue);
    return false;
}
        );

