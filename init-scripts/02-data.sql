USE hotel;

-- 초기 예약 데이터 삽입
INSERT INTO reservation (guest_name,
                         room_number,
                         check_in_date,
                         check_out_date,
                         status)
VALUES
    ('홍길동', '101', '2025-05-10', '2025-05-12', 'CONFIRMED'),
    ('김철수', '202', '2025-05-15', '2025-05-17', 'CONFIRMED');