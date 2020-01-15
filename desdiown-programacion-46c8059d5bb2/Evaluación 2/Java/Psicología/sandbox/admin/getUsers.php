<?php
require('admin.php');
if(isset($_REQUEST['length']) && isset($_REQUEST['start']) && isset($_REQUEST['draw']))
{

  $iTotalRecords = $db->query('SELECT id FROM users')->num_rows;
  $iDisplayLength = intval($_REQUEST['length']);
  $iDisplayLength = $iDisplayLength < 0 ? $iTotalRecords : $iDisplayLength; 
  $iDisplayStart = intval($_REQUEST['start']);
  $sEcho = intval($_REQUEST['draw']);
  
  $records = array();
  $records["data"] = array(); 

  $end = $iDisplayStart + $iDisplayLength;
  $end = $end > $iTotalRecords ? $iTotalRecords : $end;

  $status_list = array(
    array("success" => "Pending"),
    array("info" => "Closed"),
    array("danger" => "On Hold"),
    array("warning" => "Fraud")
  );
  
  $uInfo = $db->query('SELECT id,email,lang,dateRegistered,dateLastLogin,INET_NTOA(lastIp),INET_NTOA(registerIp),type FROM users');
  while($row = $uInfo->fetch_row())
  {
    $status = $status_list[rand(0, 2)];
    $records["data"][] = array(
      '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline"><input name="id[]" type="checkbox" class="checkboxes" value="'.$row[0].'"/><span></span></label>',
      $row[0],
      $row[1],
      $row[2],
      date('d/m/Y H:i:s',$row[3]),
      $core->timeElapsed($row[4]),
      $row[5],
      $row[6],
      ($row[7] == 'client' ? $lang['users.table.client']:$lang['users.table.psico']),
      '<a href="javascript:;" class="btn btn-sm btn-outline grey-salsa"><i class="fa fa-search"></i> View</a>',
   );
  }

  if (isset($_REQUEST["customActionType"]) && $_REQUEST["customActionType"] == "group_action") {
    $records["customActionStatus"] = "OK"; // pass custom message(useful for getting status of group actions)
    $records["customActionMessage"] = "Group action successfully has been completed. Well done!"; // pass custom message(useful for getting status of group actions)
  }

  $records["draw"] = $sEcho;
  $records["recordsTotal"] = $iTotalRecords;
  $records["recordsFiltered"] = $iTotalRecords;
  
  echo json_encode($records);
}
?>