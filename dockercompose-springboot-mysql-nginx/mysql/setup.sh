#!/bin/bash
set -e

#�鿴mysql�����״̬��������ԣ�����������ɾ��
echo `service mysql status`

echo '1.����mysql....'
#����mysql
service mysql start
sleep 3
echo `service mysql status`

echo '2.��ʼ��������....'
#��������
mysql < /mysql/schema.sql
echo '3.�����������....'

sleep 3
echo `service mysql status`

#��������mysql����
echo '4.��ʼ�޸�����....'
mysql < /mysql/privileges.sql
echo '5.�޸��������....'

#sleep 3
echo `service mysql status`
echo 'mysql�����������,�����ݵ���ɹ�'

tail -f /dev/null